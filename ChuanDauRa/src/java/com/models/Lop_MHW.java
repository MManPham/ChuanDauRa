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
 * @author Man Pham
 */
public class Lop_MHW {
    private String ten_Lop;
    private String ma_Lop;
    private List<SinhvienMonhocW> ds_SV;
    private List<CDR_MH_TBW> chuan_dau_ra_TB;
    public Lop_MHW() {
    }

    public Lop_MHW(String ten_Lop, String ma_Lop, List<SinhvienMonhocW> ds_SV) {
        this.ten_Lop = ten_Lop;
        this.ma_Lop= ma_Lop;
        this.ds_SV = ds_SV;
    }

    public String getTen_Lop() {
        return ten_Lop;
    }

    public void setTen_Lop(String ten_Lop) {
        this.ten_Lop = ten_Lop;
    }

    public List<SinhvienMonhocW> getDs_SV() {
        return ds_SV;
    }

    public String getMa_Lop() {
        return ma_Lop;
    }

    public void setMa_Lop(String ma_Lop) {
        this.ma_Lop = ma_Lop;
    }

    public void setDs_SV(List<SinhvienMonhocW> ds_SV) {
        this.ds_SV = ds_SV;
    }
    
    public void update_CDR(){
        this.chuan_dau_ra_TB = new ArrayList<>();
        int count_sv = 0;
        for( CDR_MHW x : this.ds_SV.get(0).getListCDR_MH()){
            this.chuan_dau_ra_TB.add(new CDR_MH_TBW(x.getChuanDauRaMonHoc(),0));
        }
        
        for( SinhvienMonhocW x : this.ds_SV){
            for(int i = 0; i < x.getListCDR_MH().size(); i++){
                   chuan_dau_ra_TB.get(i).setKetQua(chuan_dau_ra_TB.get(i).getKetQua()
                           + x.getListCDR_MH().get(i).getKetQua());
            }
            count_sv ++;
            
        }
        for(int i = 0; i < this.chuan_dau_ra_TB.size(); i++){
            this.chuan_dau_ra_TB.get(i).setKetQua(this.chuan_dau_ra_TB.get(i).getKetQua()/count_sv);
        }
       
    }

    public List<CDR_MH_TBW> getChuan_dau_ra_TB() {
        return chuan_dau_ra_TB;
    }

    public void setChuan_dau_ra_TB(List<CDR_MH_TBW> chuan_dau_ra_TB) {
        this.chuan_dau_ra_TB = chuan_dau_ra_TB;
    }
    
}











