package com.example.demo.Service.service;


import com.example.demo.Entity.SanPhamChiTiet;

import java.util.List;

public interface spctService {
    public List<SanPhamChiTiet> getAll();
    public void add(SanPhamChiTiet sanPhamChiTiet);
    public void update(SanPhamChiTiet sanPhamChiTiet);
    public void delete(Integer id);
    public SanPhamChiTiet findByID(Integer id);
    public SanPhamChiTiet findByTen(String ten);
}
