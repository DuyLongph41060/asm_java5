package com.example.demo.configs;

import com.example.demo.Entity.NhanVien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class UserConfigs {
    public static void main(String[] args){
        SpringApplication.run(UserConfigs.class, args);
    }

    @Bean(name = "Admin_Bean")
    public NhanVien admin(){
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTendangnhap("admin");
        nhanVien.setMatkhau("123");
        nhanVien.setChucvu("admin");
        return nhanVien;
    }
    @Bean(name = "NhanVien_Bean")
    public NhanVien nhanvien(){
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTendangnhap("nhanviensang");
        nhanVien.setMatkhau("123");
        nhanVien.setChucvu("nhanvien");
        return nhanVien;
    }
}
