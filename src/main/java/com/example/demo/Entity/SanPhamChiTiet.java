package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spct")
public class SanPhamChiTiet {
    @Id
    @Column(name = "idspct")
    @NotNull
    private int id;

    @Column(name = "maspct")
    @NotBlank
    private String ma;

    @ManyToOne
    @JoinColumn(name = "idkich_thuoc", referencedColumnName = "idkich_thuoc")
    @NotNull
    private KichThuoc kichthuoc;

    @ManyToOne
    @JoinColumn(name = "idmau_sac", referencedColumnName = "idmau_sac")
    @NotNull
    private MauSac mausac;

    @ManyToOne
    @JoinColumn(name = "idsan_pham", referencedColumnName = "idsan_pham")
    @NotNull
    private SanPham sanpham;

    @Column(name = "soluong")
    @NotNull
    private int soluong;

    @Column(name = "dongia")
    @NotNull
    private int dongia;

    @Column(name = "trangthai")
    private boolean trangThai;
}
