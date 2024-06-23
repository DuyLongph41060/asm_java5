package com.example.demo.Service.service;

import com.example.demo.Entity.NhanVien;

import java.util.List;

public interface NhanVienService {
    public List<NhanVien> getAll();
    public void add(NhanVien nhanVien);
    public void update(NhanVien nhanVien);
    public void delete(Integer id);
    public NhanVien findByID(Integer id);
    public NhanVien findByTen(String ten);
}
