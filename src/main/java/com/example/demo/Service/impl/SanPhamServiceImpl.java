package com.example.demo.Service.impl;

import com.example.demo.Entity.SanPham;
import com.example.demo.Repository.SanPhamRepo;
import com.example.demo.Service.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    private static final int PAGE_SIZE = 3;

    @Override
    public Page<SanPham> getAllPage(int p) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(p, PAGE_SIZE, sort);
        return sanPhamRepo.findAll(pageable);
    }

    @Override
    public void add(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
    }

    @Override
    public void delete(Integer id) {
        sanPhamRepo.deleteById(id);
    }

    @Override
    public SanPham findByID(Integer id) {
        return sanPhamRepo.findById(id).get();
    }

    @Override
    public SanPham findByTen(String ten) {
        return null;
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepo.findAll();
    }
}
