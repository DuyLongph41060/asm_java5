package com.example.demo.Controller;

import com.example.demo.Entity.NhanVien;
import com.example.demo.Service.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienService service;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("list",service.getAll());
        model.addAttribute("sp", new NhanVien());
        return "hienthi/nhanvien";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sp") NhanVien sp, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("list",service.getAll());
            return "hienthi/nhanvien";
        }
        service.add(sp);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        NhanVien sp = service.findByID(id);
        model.addAttribute("listSP", sp);
        return "detail/nhanviendetail";
    }
    @PostMapping("/update/{id}")
    public String update(NhanVien khachHang){
        service.update(khachHang);
        return "redirect:/nhan-vien/hien-thi";
    }
//    @GetMapping("/search")
//    public String search(@RequestParam("ten") String ten, Model model){
//        List<NhanVien> list = this.service.findByTen(ten);
//        model.addAttribute("sp", new NhanVien());
//        model.addAttribute("list", list);
//        return "hienthi/nhanvien";
//    }
}
