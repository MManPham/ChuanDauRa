/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Man Pham
 */
public class ChiTietSV_MH {
    private String maDT;
    private String phaLoai;
    private String hocKi;
    private String namHoc;
    private int cau;
    private int diem;
    private int diemToiDa;
    private String chuanDauRa;

    public ChiTietSV_MH(String maDT, String phaLoai, String hocKi, String namHoc, int cau, int diem, int diemToiDa, String chuanDauRa) {
        this.maDT = maDT;
        this.phaLoai = phaLoai;
        this.hocKi = hocKi;
        this.namHoc = namHoc;
        this.cau = cau;
        this.diem = diem;
        this.diemToiDa = diemToiDa;
        this.chuanDauRa = chuanDauRa;
    }
    public ChiTietSV_MH(ResultSet rs) throws SQLException
    {
        this.maDT = rs.getString("MADT");
        this.phaLoai = rs.getString("PHANLOAI");
        this.hocKi = rs.getString("HOCKI");
        this.namHoc = rs.getString("NAMHOC");
        this.cau = rs.getInt("CAU");
        this.diem = rs.getInt("DIEM");
        this.diemToiDa = rs.getInt("DIEMTOIDA");
        this.chuanDauRa = rs.getString("CHUANDAURA")+","+ ((float)(this.diem/(this.diemToiDa *1.0))*100) + "%";
    }

    public ChiTietSV_MH() {
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getPhaLoai() {
        return phaLoai;
    }

    public void setPhaLoai(String phaLoai) {
        this.phaLoai = phaLoai;
    }

    public String getHocKi() {
        return hocKi;
    }

    public void setHocKi(String hocKi) {
        this.hocKi = hocKi;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getCau() {
        return cau;
    }

    public void setCau(int cau) {
        this.cau = cau;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getDiemToiDa() {
        return diemToiDa;
    }

    public void setDiemToiDa(int diemToiDa) {
        this.diemToiDa = diemToiDa;
    }

    public String getChuanDauRa() {
        return chuanDauRa;
    }

    public void setChuanDauRa(String chuanDauRa) {
        this.chuanDauRa = chuanDauRa;
    }

    
}
