package com.example.demo.Service.service;

import com.example.demo.Entity.KhachHang;

import java.util.List;

public interface KhachHangService {
    public List<KhachHang> getAll();
    public void add(KhachHang khachHang);
    public void update(KhachHang khachHang);
    public void delete(Integer id);
    public KhachHang findByID(Integer id);
    public KhachHang findByTen(String ten);
}
