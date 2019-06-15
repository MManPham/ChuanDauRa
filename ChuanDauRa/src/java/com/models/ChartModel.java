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
public class ChartModel {
    List<Chart> dataArray;
    
    public ChartModel(){
        List<Chart> dataArray = new ArrayList<>();
    }

    public List<Chart> getDataArray() {
        return dataArray;
    }

    public void setDataArray(List<Chart> dataArray) {
        this.dataArray = dataArray;
    }
    
    public ChartModel( ArrayList<CDR_KH_KQW> yearOneCDRKH, ArrayList<CDR_KH_KQW> yearTwoCDRKH){
        this.dataArray = new ArrayList<>();
        yearOneCDRKH.forEach((x) -> {
            yearTwoCDRKH.forEach((y) -> {
                if(x.getChuanDaura().equals(y.getChuanDaura())){
                    
                    dataArray.add(new Chart(x.getChuanDaura(),x.getKetQua(), 0 - y.getKetQua()));
                }
            });
        });
    }
    
    
}
