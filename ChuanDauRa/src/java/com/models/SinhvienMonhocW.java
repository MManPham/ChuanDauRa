/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hayama
 */
public class SinhvienMonhocW implements Serializable {
    private String mssv;
    private String tenSV;
    private String maLopMH;
    private String tenLop;
    private Double diemqt;
    private Double diemgk;
    private Double diemth;
    private Double diemck;
    private int tinChi;
    private List<CDR_MHW> listCDR_MH;

    public SinhvienMonhocW(String mssv, String tenSV, String maLopMH, String tenLop, Double diemqt, Double diemgk, Double diemth, Double diemck, int tinChi, List<CDR_MHW> listCDR_MH) {
        this.mssv = mssv;
        this.tenSV = tenSV;
        this.maLopMH = maLopMH;
        this.tenLop = tenLop;
        this.diemqt = diemqt;
        this.diemgk = diemgk;
        this.diemth = diemth;
        this.diemck = diemck;
        this.tinChi = tinChi;
        this.listCDR_MH = listCDR_MH;
    }




    public SinhvienMonhocW() {
    }
    
    public String getMssv() {
        return mssv;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getMaLopMH() {
        return maLopMH;
    }

    public String getTenLop() {
        return tenLop;
    }

    public Double getDiemqt() {
        return diemqt;
    }

    public Double getDiemgk() {
        return diemgk;
    }

    public Double getDiemth() {
        return diemth;
    }

    public Double getDiemck() {
        return diemck;
    }

    public int getTinChi() {
        return tinChi;
    }


    public List<CDR_MHW> getListCDR_MH() {
        return listCDR_MH;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public void setMaLopMH(String maLopMH) {
        this.maLopMH = maLopMH;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setDiemqt(Double diemqt) {
        this.diemqt = diemqt;
    }

    public void setDiemgk(Double diemgk) {
        this.diemgk = diemgk;
    }

    public void setDiemth(Double diemth) {
        this.diemth = diemth;
    }

    public void setDiemck(Double diemck) {
        this.diemck = diemck;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

 

    public void setListCDR_MH(List<CDR_MHW> listCDR_MH) {
        this.listCDR_MH = listCDR_MH;
    }
    


}
