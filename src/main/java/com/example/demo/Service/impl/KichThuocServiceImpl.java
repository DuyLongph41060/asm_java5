package com.example.demo.Service.impl;

import com.example.demo.Entity.KichThuoc;
import com.example.demo.Repository.KichThuocRepo;
import com.example.demo.Service.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichThuocServiceImpl implements KichThuocService {
    @Autowired
    KichThuocRepo kichThuocRepo;

    @Override
    public List<KichThuoc> getAll() {
        return kichThuocRepo.findAll();
    }

    @Override
    public void add(KichThuoc kichThuoc) {
        kichThuocRepo.save(kichThuoc);
    }

    @Override
    public void update(KichThuoc kichThuoc) {
        kichThuocRepo.save(kichThuoc);
    }

    @Override
    public void delete(Integer id) {
        kichThuocRepo.deleteById(id);
    }

    @Override
    public KichThuoc findByID(Integer id) {
        return kichThuocRepo.findById(id).get();
    }

    @Override
    public KichThuoc findByTen(String ten) {
        return null;
    }
}
