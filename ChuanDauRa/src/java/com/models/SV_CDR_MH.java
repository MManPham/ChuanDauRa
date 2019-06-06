/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *
 * @author Man Pham
 */
public class SV_CDR_MH {
    private String chuanDauRa;
    private float tiLe;

    public SV_CDR_MH(String chuanDauRa, int diemDatDuoc, int diemToiDa) {
        this.chuanDauRa = chuanDauRa;
        this.tiLe =  (float) (diemDatDuoc/(diemToiDa*1.0))*100;
    }

    
    public String getChuanDauRa() {
        return chuanDauRa;
    }

    public void setChuanDauRa(String chuanDauRa) {
        this.chuanDauRa = chuanDauRa;
    }

    public float getTile() {
        return tiLe;
    }

    public void setTile(float tiLe) {
        this.tiLe = tiLe;
    }

    
}
