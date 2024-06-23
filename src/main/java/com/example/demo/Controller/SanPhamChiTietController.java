package com.example.demo.Controller;

import com.example.demo.Entity.KichThuoc;
import com.example.demo.Entity.MauSac;
import com.example.demo.Entity.SanPham;
import com.example.demo.Entity.SanPhamChiTiet;
import com.example.demo.Service.service.KichThuocService;
import com.example.demo.Service.service.MauSacService;
import com.example.demo.Service.service.SanPhamService;
import com.example.demo.Service.service.spctService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/spct")
public class SanPhamChiTietController {
    @Autowired
    spctService service;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    KichThuocService kichThuocService;

    @Autowired
    MauSacService mauSacService;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("sp", new SanPhamChiTiet());
        model.addAttribute("list", service.getAll());
        return "hienthi/sanphamchitiet";
    }

    @ModelAttribute("mausac")
    List<MauSac> getMauSac(){ return mauSacService.getAll(); }

    @ModelAttribute("kichthuoc")
    List<KichThuoc> getKichThuoc(){ return kichThuocService.getAll(); }

    @ModelAttribute("sanpham")
    List<SanPham> getSanPham(){ return sanPhamService.getAll(); }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sp") SanPhamChiTiet sp, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("list", service.getAll());
            return "hienthi/sanphamchitiet";
        }
        service.add(sp);
        return "redirect:/spct/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/spct/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        SanPhamChiTiet sanPhamChiTiet = service.findByID(id);
        model.addAttribute("listSP", sanPhamChiTiet);
        return "detail/sanphamchitietdetail";
    }
    @PostMapping("/update{id}")
    public String update(SanPhamChiTiet sanPhamChiTiet){
        service.update(sanPhamChiTiet);
        return "redirect:/spct/hien-thi";
    }
//    @GetMapping("/search")
//    public String search(@RequestParam("ma") String ma, Model model){
//        List<SanPhamChiTiet> list = this.service.findByMa(ma);
//        model.addAttribute("sp", new SanPhamChiTiet());
//        model.addAttribute("list",list);
//        return "hienthi/sanphamchitiet";
//    }
}
