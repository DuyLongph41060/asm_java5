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
@Table(name = "san_pham")
public class SanPham {
    @Id
    @Column(name = "idsan_pham")
    @NotNull
    private int id;

    @Column(name = "ma")
    @NotBlank
    private String ma;

    @Column(name = "ten")
    @NotBlank
    private String ten;

    @Column(name = "trangthai")
    private boolean trangThai;

    public SanPham(@NotBlank String ten) {
        this.ten = ten;
    }
}
