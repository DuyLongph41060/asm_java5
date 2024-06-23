package com.example.demo.Service.impl;

import com.example.demo.Entity.NhanVien;
import com.example.demo.Repository.NhanVienRepo;
import com.example.demo.Service.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepo nhanVienRepo;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepo.findAll();
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepo.save(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepo.save(nhanVien);
    }

    @Override
    public void delete(Integer id) {
        nhanVienRepo.deleteById(id);
    }

    @Override
    public NhanVien findByID(Integer id) {
        return nhanVienRepo.findById(id).get();
    }

    @Override
    public NhanVien findByTen(String ten) {
        return null;
    }
}
