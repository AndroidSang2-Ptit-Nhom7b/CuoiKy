package com.example.anhtuan.myapplication.model;

import java.io.Serializable;

public class CongViec implements Serializable {

    private String TenCV;
    private int NgayBD;
    private int ThangBD;
    private int NamBD;
    private int NgayKT;
    private int ThangKT;
    private int NamKT;

    public CongViec(String tenCV, int ngayBD, int thangBD, int namBD, int ngayKT, int thangKT, int namKT) {
        TenCV = tenCV;
        NgayBD = ngayBD;
        ThangBD = thangBD;
        NamBD = namBD;
        NgayKT = ngayKT;
        ThangKT = thangKT;
        NamKT = namKT;
    }

    public String getTenCV() {
        return TenCV;
    }

    public int getNgayBD() {
        return NgayBD;
    }

    public int getThangBD() {
        return ThangBD;
    }

    public int getNamBD() {
        return NamBD;
    }

    public int getNgayKT() {
        return NgayKT;
    }

    public int getThangKT() {
        return ThangKT;
    }

    public int getNamKT() {
        return NamKT;
    }
}
