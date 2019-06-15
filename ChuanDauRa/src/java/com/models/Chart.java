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
public class Chart {
    public String chuanDauRa;
    public float ketQuaNienKhoaDau;
    public float ketQuaNienKhoaSau;

    public Chart(String chuanDauRa, float ketQuaNienKhoaDau, float ketQuaNienKhoaSau) {
        this.chuanDauRa = chuanDauRa;
        this.ketQuaNienKhoaDau = ketQuaNienKhoaDau;
        this.ketQuaNienKhoaSau = ketQuaNienKhoaSau;
    }

    public Chart() {
    }

    public String getChuanDauRa() {
        return chuanDauRa;
    }

    public void setChuanDauRa(String chuanDauRa) {
        this.chuanDauRa = chuanDauRa;
    }

    public String getKetQuaNienKhoaDau() {
        return ketQuaNienKhoaDau + "";
    }
    
    public void setKetQuaNienKhoaDau(int ketQuaNienKhoaDau) {
        this.ketQuaNienKhoaDau = ketQuaNienKhoaDau;
    }

    public String getKetQuaNienKhoaSau() {
        return ketQuaNienKhoaSau + "";
    }

    public void setKetQuaNienKhoaSau(int ketQuaNienKhoaSau) {
        this.ketQuaNienKhoaSau = ketQuaNienKhoaSau;
    }
    
    
}
