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
public class testCDR_KH {
    private List<CDR_KH_KQ> danhSach_CDR_CN;
    
     public testCDR_KH() {
     
     }
    public testCDR_KH(List<CDR_KH_KQ> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = danhSach_CDR_CN;
    }
    
    public List<CDR_KH_KQ> getDanhSach_CDR_CN() {
        return danhSach_CDR_CN;
    }

    public void setDanhSach_CDR_CN(List<CDR_KH_KQ> danhSach_CDR_CN) {
        this.danhSach_CDR_CN = danhSach_CDR_CN;
    }

}
