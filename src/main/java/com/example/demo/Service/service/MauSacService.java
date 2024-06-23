package com.example.demo.Service.service;

import com.example.demo.Entity.MauSac;

import java.util.List;

public interface MauSacService {
    public List<MauSac> getAll();
    public void add(MauSac mauSac);
    public void update(MauSac mauSac);
    public void delete(Integer id);
    public MauSac findByID(Integer id);
    public MauSac findByTen(String ten);
}
