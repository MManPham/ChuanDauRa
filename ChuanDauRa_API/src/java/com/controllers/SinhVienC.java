/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import com.models.Sinhvien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.main.ConnectDB;
import com.models.CDR_KH;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 *
 * @author Man Pham
 */
@Path("sinhvien")
public class SinhVienC {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Sinhvien> getAllSV() throws ClassNotFoundException, SQLException {
        ArrayList<Sinhvien> listSv = new ArrayList<>();

        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM SINHVIEN").executeQuery();
            while (rs.next()) {
                Sinhvien newSv = new Sinhvien(
                        rs.getString("MSSV"),
                        rs.getString("TENSV"),
                        rs.getString("SODT"),
                        rs.getString("NIENKHOA"),
                        rs.getString("PASSW"),
                        rs.getString("MACHUYENNGANH")
                );
                listSv.add(newSv);
            }
            return listSv;

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return null;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sinhvien findSV(@PathParam("id") String id) throws ClassNotFoundException {
        Sinhvien newSv = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM SINHVIEN WHERE MSSV = " + id).executeQuery();
            while (rs.next()) {
                newSv = new Sinhvien(
                        rs.getString("MSSV"),
                        rs.getString("TENSV"),
                        rs.getString("SODT"),
                        rs.getString("NIENKHOA"),
                        rs.getString("PASSW"),
                        rs.getString("MACHUYENNGANH"),
                        get_CDR_MH(rs.getString("MACHUYENNGANH"))
                );
            }
            return newSv;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return null;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public CDR_KH get_CDR_MH(String maCN) throws ClassNotFoundException {
        Sinhvien newSv = null;
        Connection con = null;
        ResultSet rs = null;
        List<String> list_cdr = new ArrayList<>();
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM CDR_CN WHERE MACHUYENNGANH ='"+maCN+"'").executeQuery();
            while (rs.next()) {
                list_cdr.add(rs.getString("CDRKH"));
                
            }
            return new CDR_KH(list_cdr);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return null;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}





