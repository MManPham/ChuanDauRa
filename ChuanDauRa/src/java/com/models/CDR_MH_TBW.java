/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *
 * @author Hayama
 */
public class CDR_MH_TBW {
    private String chuanDauRaMonHoc;
    private float ketQua;

    public CDR_MH_TBW() {
    }

    public CDR_MH_TBW(String chuanDauRaMonHoc, float ketQua) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
        this.ketQua = ketQua;
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
    
    
}
