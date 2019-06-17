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
public class ListCDR_MH {
    private String maMon;
    private List<CDR_MH> danhSach_CDR_CN;
    
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaMon() {
        return maMon;
    }
    public ListCDR_MH() {
        danhSach_CDR_CN = new ArrayList<>();
    }
    
    public void setDanhSach_CDR_CN(List<CDR_MH> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = danhSach_CDR_CN;
    }

    public List<CDR_MH> getDanhSach_CDR_CN() {
        return danhSach_CDR_CN;
    }
    
    public void add(CDR_MH cdr_mh) {
        danhSach_CDR_CN.add(cdr_mh);
    }

    public ListCDR_MH(String maMon, List<CDR_MH> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = new ArrayList<>();
        this.maMon = maMon;
        for(CDR_MH x : danhSach_CDR_CN){
            this.danhSach_CDR_CN.add(x);
        }
    }
}
