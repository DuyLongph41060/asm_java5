package com.example.demo.Controller;

import com.example.demo.Entity.MauSac;
import com.example.demo.Service.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    MauSacService service;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("list",service.getAll());
        model.addAttribute("sp", new MauSac());
        return "hienthi/mausac";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sp")MauSac sp, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("list",service.getAll());
            return "hienthi/mausac";
        }
        service.add(sp);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        MauSac sp = service.findByID(id);
        model.addAttribute("listSP", sp);
        return "detail/mausacdetail";
    }
    @PostMapping("/update/{id}")
    public String update(MauSac kichThuoc){
        service.update(kichThuoc);
        return "redirect:/mau-sac/hien-thi";
    }
//    @GetMapping("/search")
//    public String search(@RequestParam("ten") String ten, Model model){
//        List<MauSac> list = this.service.findByTen(ten);
//        model.addAttribute("sp", new MauSac());
//        model.addAttribute("list", list);
//        return "hienthi/mausac";
//    }
}
