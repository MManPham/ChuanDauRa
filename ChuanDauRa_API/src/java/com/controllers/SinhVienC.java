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
    public ArrayList<Sinhvien> getDataJson() throws ClassNotFoundException, SQLException{
        ArrayList <Sinhvien> listSv = new ArrayList<>();
        ResultSet rs = ConnectDB.getPreparedStatement("SELECT * FROM SINHVIEN").executeQuery();
        while(rs.next())
        {
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
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sinhvien find(@PathParam("id") String id) {
        Sinhvien newSv = null;
        try {
            ResultSet rs = ConnectDB.getPreparedStatement("SELECT * FROM SINHVIEN WHERE MSSV = "+id).executeQuery();
            while(rs.next())
            {
                newSv = new Sinhvien(
                    rs.getString("MSSV"),
                    rs.getString("TENSV"),   
                    rs.getString("SODT"),
                    rs.getString("NIENKHOA"),
                    rs.getString("PASSW"),
                    rs.getString("MACHUYENNGANH")
                );
            }
            return newSv;
        } catch (SQLException e) {
            System.out.println("Error: " +e);
            return null;
        }
    }
    
}