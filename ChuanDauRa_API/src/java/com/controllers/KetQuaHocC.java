/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.main.ConnectDB;
import com.models.SinhvienMonhoc;
import com.models.SinhvienMonhoc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Hayama
 */
@Path("ketquahoc")
public class KetQuaHocC {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDataJson() throws ClassNotFoundException, SQLException {
        
            return "test ket qua hoc";
        

    }
    
    @GET
     @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SinhvienMonhoc> find(@PathParam("id") String mssv) throws ClassNotFoundException {
        List<SinhvienMonhoc> listSv = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        SinhVienC sv_C = new SinhVienC();

        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT SVMH.MSSV, MH.MAMH, SVMH.MALOPMH, SVMH.DIEMQT, SVMH.DIEMGK, SVMH.DIEMTH, SVMH.DIEMCK, MH.TINCHI " +
                                        "FROM SINHVIEN_MONHOC SVMH, MONHOC MH, LOPMONHOC LMH " +
                                        "WHERE SVMH.MALOPMH = LMH.MALOPMH AND LMH.MAMON = MH.MAMH AND SVMH.MSSV = '"+ mssv  +"'").executeQuery();
            while (rs.next()) {
                SinhvienMonhoc newSv = new SinhvienMonhoc(
                        rs.getString("MSSV"),
                        getNameSV(mssv),
                        rs.getString("MALOPMH"),
                        getNameLopMh(rs.getString("MALOPMH")),
                        rs.getDouble("DIEMQT"),
                        rs.getDouble("DIEMGK"),
                        rs.getDouble("DIEMTH"),
                        rs.getDouble("DIEMCK"),
                        rs.getInt("TINCHI"),
                        sv_C.getCDR_MH(rs.getString("MSSV"), rs.getString("MAMH"))
                        
                        
                //callProcedure("PROC_IN_MSSV_MAMH_KQ", rs.getString("MSSV"), rs.getString("MALOPMH"))
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
    
    public String getNameSV(String mssv) throws ClassNotFoundException{
        String result = null;
        Connection con = null;
        ResultSet rs = null;
        

        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT TENSV FROM SINHVIEN WHERE MSSV = '"+ mssv +"'").executeQuery();
            rs.next();
            result = rs.getString("TENSV");                

            return result;
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
    
    public String getNameLopMh(String maLop) throws ClassNotFoundException{
                String result = null;
        Connection con = null;
        ResultSet rs = null;
        

        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT TENLOPMH FROM LOPMONHOC WHERE MALOPMH = '"+ maLop+"'").executeQuery();
            rs.next();
            result = rs.getString("TENLOPMH");                

            return result;
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
