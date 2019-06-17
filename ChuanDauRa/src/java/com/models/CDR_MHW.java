/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hayama
 */
public class CDR_MHW {
    private String chuanDauRaMonHoc;
    private float ketQua;
    private List<CDR_KH_KQW> chuanDauRaKhoaHoc;

    public CDR_MHW(String chuanDauRaMonHoc, float ketQua, List<CDR_KH_KQW> chuanDauRaKhoaHoc) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
        this.ketQua = ketQua;
        this.chuanDauRaKhoaHoc = chuanDauRaKhoaHoc;
    }

    public CDR_MHW() {
    }

    public String getChuanDauRaMonHoc() {
        return chuanDauRaMonHoc;
    }

    public void setChuanDauRaMonHoc(String chuanDauRaMonHoc) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
    }

    public float getKetQua() {
        return ketQua;
    }

    public void setKetQua(float ketQua) {
        this.ketQua = ketQua;
    }

    public List<CDR_KH_KQW> getChuanDauRaKhoaHoc() {
        return chuanDauRaKhoaHoc;
    }

    public void setChuanDauRaKhoaHoc(List<CDR_KH_KQW> chuanDauRaKhoaHoc) {
        this.chuanDauRaKhoaHoc = chuanDauRaKhoaHoc;
    }

    public CDR_MHW(String chuanDauRaMonHoc, float ketQua) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
        this.ketQua = ketQua;
    }

    
        
    
            
}
