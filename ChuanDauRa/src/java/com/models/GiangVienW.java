/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.List;

/**
 *
 * @author Hayama
 */
public class GiangVienW {
    private String maSoGiangVien;
    private String tenGiangVien;
    private List<Lop_MHW> danhSachLopMH;
    private List<Lop_CNW> danhSachLopCN;


    public GiangVienW(){
        
    }
    public GiangVienW(String maSoGiangVien, String tenGiangVien, List<Lop_MHW> danhSachLopMH,List<Lop_CNW> danhSachLopCN) {
        this.maSoGiangVien = maSoGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.danhSachLopMH = danhSachLopMH;
        this.danhSachLopCN = danhSachLopCN;
    }



    public GiangVienW(String maSoGiangVien, String tenGiangVien) {
        this.maSoGiangVien = maSoGiangVien;
        this.tenGiangVien = tenGiangVien;
    }

    public void setMaSoGiangVien(String maSoGiangVien) {
        this.maSoGiangVien = maSoGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public void setDanhSachLopMH(List<Lop_MHW> danhSachLopMH) {
        this.danhSachLopMH = danhSachLopMH;
    }

    public String getMaSoGiangVien() {
        return maSoGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public List<Lop_MHW> getDanhSachLopMH() {
        return danhSachLopMH;
    }

    public List<Lop_CNW> getDanhSachLopCN() {
        return danhSachLopCN;
    }

    public void setDanhSachLopCN(List<Lop_CNW> danhSachLopCN) {
        this.danhSachLopCN = danhSachLopCN;
    }
    
    
           
    
    
}











