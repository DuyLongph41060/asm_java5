package com.example.demo.Service.service;

import com.example.demo.Entity.KichThuoc;

import java.util.List;

public interface KichThuocService {
    public List<KichThuoc> getAll();
    public void add(KichThuoc kichThuoc);
    public void update(KichThuoc kichThuoc);
    public void delete(Integer id);
    public KichThuoc findByID(Integer id);
    public KichThuoc findByTen(String ten);
}
