package com.dduongdev.entities;

public enum LoaiTN {
    XUAT_SAC("Xuất sắc"),
    GIOI("Giỏi"),
    KHA("Khá"),
    TRUNG_BINH("Trung bình"),
    KHONG_DAT("Không đạt");

    private final String hienThi;

    LoaiTN(String hienThi) {
        this.hienThi = hienThi;
    }

    public String getHienThi() {
        return hienThi;
    }
}
