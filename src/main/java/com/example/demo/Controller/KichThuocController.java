package com.example.demo.Controller;

import com.example.demo.Entity.KichThuoc;
import com.example.demo.Service.service.KichThuocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kich-thuoc")
public class KichThuocController {
    @Autowired
    KichThuocService service;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("list",service.getAll());
        model.addAttribute("sp", new KichThuoc());
        return "hienthi/kichthuoc";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sp")KichThuoc sp, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("list",service.getAll());
            return "hienthi/kichthuoc";
        }
        service.add(sp);
        return "redirect:/kich-thuoc/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/kich-thuoc/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        KichThuoc sp = service.findByID(id);
        model.addAttribute("listSP", sp);
        return "detail/kichthuocdetail";
    }
    @PostMapping("/update/{id}")
    public String update(KichThuoc kichThuoc){
        service.update(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }
//    @GetMapping("/search")
//    public String search(@RequestParam("ten") String ten, Model model){
//        List<KichThuoc> list = this.service.findByTen(ten);
//        model.addAttribute("sp", new KichThuoc());
//        model.addAttribute("list", list);
//        return "hienthi/kichthuoc";
//    }
}
