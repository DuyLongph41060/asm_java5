package com.example.demo.Service.impl;

import com.example.demo.Entity.SanPhamChiTiet;
import com.example.demo.Repository.spctRepo;
import com.example.demo.Service.service.spctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class spctServiceImpl implements spctService {
    @Autowired
    spctRepo spctRepo;

    @Override
    public List<SanPhamChiTiet> getAll() {
        return spctRepo.findAll();
    }

    @Override
    public void add(SanPhamChiTiet sanPhamChiTiet) {
        spctRepo.save(sanPhamChiTiet);
    }

    @Override
    public void update(SanPhamChiTiet sanPhamChiTiet) {
        spctRepo.save(sanPhamChiTiet);
    }

    @Override
    public void delete(Integer id) {
        spctRepo.deleteById(id);
    }

    @Override
    public SanPhamChiTiet findByID(Integer id) {
        return spctRepo.findById(id).get();
    }

    @Override
    public SanPhamChiTiet findByTen(String ten) {
        return null;
    }
}
