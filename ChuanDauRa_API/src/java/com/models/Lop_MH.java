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
public class Lop_MH {
    private String ten_Lop;
    private String ma_Lop;
    private List<SinhvienMonhoc> ds_SV;

    public Lop_MH() {
    }

    public Lop_MH(String ten_Lop, String ma_Lop, List<SinhvienMonhoc> ds_SV) {
        this.ten_Lop = ten_Lop;
        this.ma_Lop= ma_Lop;
        this.ds_SV = ds_SV;
    }

    public String getMa_Lop() {
        return ma_Lop;
    }

    public void setMa_Lop(String ma_Lop) {
        this.ma_Lop = ma_Lop;
    }

    public String getTen_Lop() {
        return ten_Lop;
    }

    public void setTen_Lop(String ten_Lop) {
        this.ten_Lop = ten_Lop;
    }

    public List<SinhvienMonhoc> getDs_SV() {
        return ds_SV;
    }

    public void setDs_SV(List<SinhvienMonhoc> ds_SV) {
        this.ds_SV = ds_SV;
    }
    
    
}








