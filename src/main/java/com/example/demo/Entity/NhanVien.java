package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhan_viens")
public class NhanVien {
    @Id
    @Column(name = "idnhan_vien")
    @NotNull
    private int id;

    @Column(name = "ten")
    @NotBlank
    private String ten;

    @Column(name = "manv")
    @NotBlank
    private String ma;

    @Column(name = "tendangnhap")
    @NotBlank
    private String tendangnhap;

    @Column(name = "matkhau")
    @NotBlank
    private String matkhau;

    @Column(name = "chucvu")
    private String chucvu;

    @Column(name = "trangthai")
    private boolean trangThai;
}
