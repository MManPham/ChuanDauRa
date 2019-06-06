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
public class Account {
    private String id;
    private String password;
    private Boolean isTruongKhoa;

    public Account() {
    }

    public Account(String id, String password) {
        this.id = id;
        this.password = password;
        this.isTruongKhoa = false;
    }

    public Boolean getIsTruongKhoa() {
        return isTruongKhoa;
    }

    public void setIsTruongKhoa(Boolean isTruongKhoa) {
        this.isTruongKhoa = isTruongKhoa;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
}







