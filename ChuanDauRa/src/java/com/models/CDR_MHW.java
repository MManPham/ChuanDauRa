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
public class CDR_MHW {
    private String chuanDauRaMonHoc;
    private float ketQua;
    
    public CDR_MHW(){
        
    }
    
    public CDR_MHW(String chuanDauRaMonHoc, float ketQua) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
        this.ketQua = (float)(Math.floor(ketQua *10)/10);
    }

    public void setChuanDauRaMonHoc(String chuanDauRaMonHoc) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
    }

    public void setKetQua(float ketQua) {
        this.ketQua = ketQua;
    }

    public String getChuanDauRaMonHoc() {
        return chuanDauRaMonHoc;
    }

    public float getKetQua() {
        return ketQua;
    }
}







