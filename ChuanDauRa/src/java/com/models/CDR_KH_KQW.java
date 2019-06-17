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
public class CDR_KH_KQW {
    String chuanDaura;
    float ketQua;
    
    public CDR_KH_KQW(){
    
    }
    
    public CDR_KH_KQW(String string, float i) {
        this.chuanDaura = string;
        this.ketQua = i;
    }

    public void setChuanDaura(String chuanDaura) {
        this.chuanDaura = chuanDaura;
    }

    public void setKetQua(float ketQua) {
        this.ketQua = ketQua;
    }

    public String getChuanDaura() {
        return chuanDaura;
    }

    public float getKetQua() {
        return ketQua;
    }
    
    
    
}
