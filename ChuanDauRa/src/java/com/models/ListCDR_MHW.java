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
public class ListCDR_MHW {
 
    private String maMon;
    private List<CDR_MHW> danhSach_CDR_CN;
    
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaMon() {
        return maMon;
    }
    public ListCDR_MHW() {
        danhSach_CDR_CN = new ArrayList<>();
    }
    
    public void setDanhSach_CDR_CN(List<CDR_MHW> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = danhSach_CDR_CN;
    }

    public List<CDR_MHW> getDanhSach_CDR_CN() {
        return danhSach_CDR_CN;
    }
    
    public void add(CDR_MHW cdr_mh) {
        danhSach_CDR_CN.add(cdr_mh);
    }

    public ListCDR_MHW(String maMon, List<CDR_MHW> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = new ArrayList<>();
        this.maMon = maMon;
        for(CDR_MHW x : danhSach_CDR_CN){
            this.danhSach_CDR_CN.add(x);
        }
    }
    
    
    
    
}
