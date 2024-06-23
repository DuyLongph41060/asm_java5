package com.example.demo.Controller;

import com.example.demo.Entity.SanPham;
import com.example.demo.Repository.SanPhamRepo;
import com.example.demo.Service.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamService service;

    @GetMapping("/hien-thi")
    public String showList(Model model, @RequestParam(name = "p", defaultValue = "0") int p){
        model.addAttribute("list", service.getAllPage(p));
        model.addAttribute("sp", new SanPham());
        return "hienthi/sanpham";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sp")SanPham sp, BindingResult result, Model model
    ){
        if (result.hasErrors()){
            model.addAttribute("list",service.getAll());
            return "hienthi/sanpham";
        }
        service.add(sp);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        SanPham sp = service.findByID(id);
        model.addAttribute("listSP", sp);
        return "detail/sanphamdetail";
    }
    @PostMapping("/update/{id}")
    public String update(SanPham sanPham){
        service.update(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
//
//    @Autowired
//    SanPhamRepo sanPhamRepo;
//
//    @GetMapping("/search")
//    public String search(@RequestParam("ten") String ten, Model model){
//        List<SanPham> list = sanPhamRepo.findSanPhamByName(ten);
//        model.addAttribute("sp", new SanPham());
//        model.addAttribute("list", list);
//        return "hienthi/sanpham";
//    }

}
