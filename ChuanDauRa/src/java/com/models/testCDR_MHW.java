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
public class testCDR_MHW {
    private String chuanDauRaMonHoc;
    private float ketQua;
    private List<CDR_KH_KQW> chuanDauRaKhoaHoc;

    public void setChuanDauRaKhoaHoc(List<CDR_KH_KQW> chuanDauRaKhoaHoc) {
        this.chuanDauRaKhoaHoc = chuanDauRaKhoaHoc;
    }

    public List<CDR_KH_KQW> getChuanDauRaKhoaHoc() {
        return chuanDauRaKhoaHoc;
    }

    public testCDR_MHW(String chuanDauRaMonHoc, float ketQua, List<CDR_KH_KQW> chuanDauRaKhoaHoc) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
        this.ketQua = ketQua;
        this.chuanDauRaKhoaHoc = new ArrayList<>(chuanDauRaKhoaHoc);
    }
    public testCDR_MHW(){
        
    }
    
    public testCDR_MHW(String chuanDauRaMonHoc, float ketQua) {
        this.chuanDauRaMonHoc = chuanDauRaMonHoc;
        this.ketQua = ketQua;
        this.chuanDauRaKhoaHoc = new ArrayList<>();
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
    
    public void addCDR_KH(String CDR_KH, float ketqua){
        CDR_KH_KQW temp = new CDR_KH_KQW(CDR_KH, ketqua);
        this.chuanDauRaKhoaHoc.add(temp);
        
        
    }
    
            
}
