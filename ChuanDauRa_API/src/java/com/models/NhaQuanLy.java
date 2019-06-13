/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hayama
 */
public class NhaQuanLy implements Serializable  {
    private String maNhaQuanLy;
    private String tenNhaQuanLy;
    private String maKhoa;
    private List<GiangVien> danhSachGiangVien;

    public NhaQuanLy() {
    }

    public NhaQuanLy(String maNhaQuanLy, String tenNhaQuuanLy, String maKhoa) {
        this.maNhaQuanLy = maNhaQuanLy;
        this.tenNhaQuanLy = tenNhaQuuanLy;
        this.maKhoa = maKhoa;
    }

    public NhaQuanLy(String maNhaQuanLy, String tenNhaQuuanLy, String maKhoa, List<GiangVien> danhSachGiangVien) {
        this.maNhaQuanLy = maNhaQuanLy;
        this.tenNhaQuanLy = tenNhaQuuanLy;
        this.maKhoa = maKhoa;
        this.danhSachGiangVien = danhSachGiangVien;
    }

    
    
    public String getTenNhaQuuanLy() {
        return tenNhaQuanLy;
    }

    public List<GiangVien> getDanhSachGiangVien() {
        return danhSachGiangVien;
    }

    public void setTenNhaQuuanLy(String tenNhaQuuanLy) {
        this.tenNhaQuanLy = tenNhaQuuanLy;
    }

    public void setDanhSachGiangVien(List<GiangVien> danhSachGiangVien) {
        this.danhSachGiangVien = danhSachGiangVien;
    }

    public void setMaNhaQuanLy(String maNhaQuanLy) {
        this.maNhaQuanLy = maNhaQuanLy;
    }

    public void setTenNhaQuanLy(String tenNhaQuanLy) {
        this.tenNhaQuanLy = tenNhaQuanLy;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getMaNhaQuanLy() {
        return maNhaQuanLy;
    }

    public String getTenNhaQuanLy() {
        return tenNhaQuanLy;
    }

    public String getMaKhoa() {
        return maKhoa;
    }
    
    
    
}
