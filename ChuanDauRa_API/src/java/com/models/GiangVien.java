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
public class GiangVien {
    private String maSoGiangVien;
    private String tenGiangVien;
    private List<Lop_MH> danhSachLopMH;
    private List<Lop_CN> danhSachLopCN;


    public GiangVien(){
        
    }
    public GiangVien(String maSoGiangVien, String tenGiangVien, List<Lop_MH> danhSachLopMH,List<Lop_CN> danhSachLopCN) {
        this.maSoGiangVien = maSoGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.danhSachLopMH = danhSachLopMH;
        this.danhSachLopCN = danhSachLopCN;
    }



    public GiangVien(String maSoGiangVien, String tenGiangVien) {
        this.maSoGiangVien = maSoGiangVien;
        this.tenGiangVien = tenGiangVien;
    }

    public void setMaSoGiangVien(String maSoGiangVien) {
        this.maSoGiangVien = maSoGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public void setDanhSachLopMH(List<Lop_MH> danhSachLopMH) {
        this.danhSachLopMH = danhSachLopMH;
    }

    public String getMaSoGiangVien() {
        return maSoGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public List<Lop_MH> getDanhSachLopMH() {
        return danhSachLopMH;
    }

    public List<Lop_CN> getDanhSachLopCN() {
        return danhSachLopCN;
    }

    public void setDanhSachLopCN(List<Lop_CN> danhSachLopCN) {
        this.danhSachLopCN = danhSachLopCN;
    }
    
    
           
    
    
}










