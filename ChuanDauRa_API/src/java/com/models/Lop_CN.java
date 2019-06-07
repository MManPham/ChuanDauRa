/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.List;

/**
 *
 * @author Man Pham
 */
public class Lop_CN {
    private String ten_Lop;
    private List<Sinhvien> ds_SV;

    public Lop_CN() {
    }

    public Lop_CN(String ten_Lop, List<Sinhvien> ds_SV) {
        this.ten_Lop = ten_Lop;
        this.ds_SV = ds_SV;
    }

    public String getTen_Lop() {
        return ten_Lop;
    }

    public void setTen_Lop(String ten_Lop) {
        this.ten_Lop = ten_Lop;
    }

    public List<Sinhvien> getDs_SV() {
        return ds_SV;
    }

    public void setDs_SV(List<Sinhvien> ds_SV) {
        this.ds_SV = ds_SV;
    }
    
    
}






