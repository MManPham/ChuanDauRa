/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;

/**
 *
 * @author Man Pham
 */
public class SinhvienMonhocW implements Serializable {

    private String mssv;
    private String maLopMH;
    private String tenLop;
    private Double diemqt;
    private Double diemgk;
    private Double diemth;
    private Double diemck;
    private ArrayList<ChiTietSV_MH> dsChiTietSV;
    private ListCDR_MHW listCDR_MH;



    public SinhvienMonhocW() {
    }

    public SinhvienMonhocW(String mssv, String maLopMH, String tenLop, Double diemqt, Double diemgk, Double diemth, Double diemck, ListCDR_MHW listCDR_MH) {
        this.mssv = mssv;
        this.maLopMH = maLopMH;
        this.tenLop = tenLop;
        this.diemqt = diemqt;
        this.diemgk = diemgk;
        this.diemth = diemth;
        this.diemck = diemck;
        this.listCDR_MH = listCDR_MH;
    }

    
    public SinhvienMonhocW(String mssv, String maLopMH, String tenLop, Double diemqt, Double diemgk, Double diemth, Double diemck, ArrayList<ChiTietSV_MH> chiTietSV) {
        this.mssv = mssv;
        this.maLopMH = maLopMH;
        this.tenLop = tenLop;
        this.diemqt = diemqt;
        this.diemgk = diemgk;
        this.diemth = diemth;
        this.diemck = diemck;
        this.dsChiTietSV = chiTietSV;
    }

    public SinhvienMonhocW(ResultSet rs, String tenLop, ArrayList<ChiTietSV_MH> chiTietSV) throws SQLException {
        this.mssv = rs.getString("MSSV");
        this.maLopMH = rs.getString("MALOPMH");
        this.tenLop = tenLop;
        this.diemqt = rs.getDouble("DIEMQT");
        this.diemgk = rs.getDouble("DIEMGK");
        this.diemth = rs.getDouble("DIEMTH");
        this.diemck = rs.getDouble("DIEMCK");
        this.dsChiTietSV = chiTietSV;
    }

  
    public ArrayList<ChiTietSV_MH> getDsChiTietSV() {
        return dsChiTietSV;
    }

    public void setDsChiTietSV(ArrayList<ChiTietSV_MH> dsChiTietSV) {
        this.dsChiTietSV = dsChiTietSV;
    }

    public ListCDR_MHW getListCDR_MH() {
        return listCDR_MH;
    }

    public void setListCDR_MH(ListCDR_MHW listCDR_MH) {
        this.listCDR_MH = listCDR_MH;
    }

 

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public ArrayList<ChiTietSV_MH> getChiTietSV() {
        return dsChiTietSV;
    }

    public void setChiTietSV(ArrayList<ChiTietSV_MH> chiTietSV) {
        this.dsChiTietSV = chiTietSV;
    }

    public Double getDiemqt() {
        return diemqt;
    }

    public void setDiemqt(Double diemqt) {
        this.diemqt = diemqt;
    }

    public Double getDiemgk() {
        return diemgk;
    }

    public void setDiemgk(Double diemgk) {
        this.diemgk = diemgk;
    }

    public Double getDiemth() {
        return diemth;
    }

    public void setDiemth(Double diemth) {
        this.diemth = diemth;
    }

    public Double getDiemck() {
        return diemck;
    }

    public void setDiemck(Double diemck) {
        this.diemck = diemck;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getMaLopMH() {
        return this.maLopMH;
    }

    public void setMaLopMH(String malopmh) {
        this.mssv = malopmh;
    }

}




