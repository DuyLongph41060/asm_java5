package com.example.demo.Service.service;

import com.example.demo.Entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SanPhamService {
    public Page<SanPham> getAllPage(int p);
    public void add(SanPham sanPham);
    public void update(SanPham sanPham);
    public void delete(Integer id);
    public SanPham findByID(Integer id);
    public SanPham findByTen(String ten);
    public List<SanPham> getAll();
}
