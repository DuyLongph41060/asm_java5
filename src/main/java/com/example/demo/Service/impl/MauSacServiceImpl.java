package com.example.demo.Service.impl;

import com.example.demo.Entity.MauSac;
import com.example.demo.Repository.MauSacRepo;
import com.example.demo.Service.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepo mauSacRepo;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepo.findAll();
    }

    @Override
    public void add(MauSac mauSac) {
        mauSacRepo.save(mauSac);
    }

    @Override
    public void update(MauSac mauSac) {
        mauSacRepo.save(mauSac);
    }

    @Override
    public void delete(Integer id) {
        mauSacRepo.deleteById(id);
    }

    @Override
    public MauSac findByID(Integer id) {
        return mauSacRepo.findById(id).get();
    }

    @Override
    public MauSac findByTen(String ten) {
        return mauSacRepo.findById(Integer.valueOf(ten)).get();
    }
}
