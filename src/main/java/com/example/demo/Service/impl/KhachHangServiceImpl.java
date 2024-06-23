package com.example.demo.Service.impl;

import com.example.demo.Entity.KhachHang;
import com.example.demo.Repository.KhachHangRepo;
import com.example.demo.Service.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepo.findAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepo.save(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachHangRepo.save(khachHang);
    }

    @Override
    public void delete(Integer id) {
        khachHangRepo.deleteById(id);
    }

    @Override
    public KhachHang findByID(Integer id) {
        return khachHangRepo.findById(id).get();
    }

    @Override
    public KhachHang findByTen(String ten) {
        return khachHangRepo.findById(Integer.valueOf(ten)).get();
    }
}
