package com.example.demo.Controller;

import com.example.demo.Entity.NhanVien;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("Admin_Bean")
    private NhanVien admin;

    @Autowired
    @Qualifier("NhanVien_Bean")
    private NhanVien nhanvien;

    @RequestMapping("/form")
    public String form(){
        return "hienthi/login";
    }

    @PostMapping("checkLogin")
    public String checkLogin(Model model, @RequestParam("tendangnhap") String tendangnhap,
                                          @RequestParam("matkhau") String matkhau,
                             HttpSession session
                             ){
        NhanVien user = null;
        if (admin.getTendangnhap().equals(tendangnhap) && admin.getMatkhau().equals(matkhau)){
            user = admin;
        } else if (nhanvien.getTendangnhap().equals(tendangnhap) && nhanvien.getMatkhau().equals(matkhau)){
            user = nhanvien;
        }

        if (user != null){
            session.setAttribute("tendangnhap", tendangnhap);
            session.setAttribute("chucvu", user.getChucvu());
            return "redirect:/san-pham/hien-thi";
        } else {
            model.addAttribute("errors", "Login Failed");
            model.addAttribute("tendangnhap", tendangnhap);
            model.addAttribute("matkhau", matkhau);
            return "hienthi/login";
        }

    }
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login/form";
    }

//    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
//    public String login(User loginRequest, Model model){
//        String username = loginRequest.getUsername();
//        String passworld = loginRequest.getPassworld();
//        if (username.equals("duylong") && passworld.equals("duylong123")){
//            model.addAttribute("username", username);
//            model.addAttribute("passworld", passworld);
//            return "redirect:/san-pham/hien-thi";
//        }
//        model.addAttribute("mess", "Vui long nhap lai !");
//        return "hienthi/login";
//    }
}
