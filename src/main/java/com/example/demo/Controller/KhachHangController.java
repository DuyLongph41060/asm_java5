package com.example.demo.Controller;

import com.example.demo.Entity.KhachHang;
import com.example.demo.Service.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService service;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("list",service.getAll());
        model.addAttribute("sp", new KhachHang());
        return "hienthi/khachhang";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sp") KhachHang sp, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("list",service.getAll());
            return "hienthi/khachhang";
        }
        service.add(sp);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        KhachHang sp = service.findByID(id);
        model.addAttribute("listSP", sp);
        return "detail/khachhangdetail";
    }
    @PostMapping("/update/{id}")
    public String update(KhachHang khachHang){
        service.update(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
//    @GetMapping("/search")
//    public String search(@RequestParam("ten") String ten, Model model){
//        List<KhachHang> list = this.service.findByTen(ten);
//        model.addAttribute("sp", new KhachHang());
//        model.addAttribute("list", list);
//        return "hienthi/khachhang";
//    }
}
