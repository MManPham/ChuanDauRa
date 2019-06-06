/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.List;

/**
 *
 * @author Man Pham
 */
public class CDR_KH {
    private List<String> danhSach_CDR_CN;
    
    public CDR_KH() {   
    }

    public CDR_KH(List<String> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = danhSach_CDR_CN;
    }

    public List<String> getdanhSach_CDR_CN() {
        return danhSach_CDR_CN;
    }

    public void setdanhSach_CDR_CN(List<String> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = danhSach_CDR_CN;
    }
    
    
}



