/*
 * To change String license header, choose License Headers in Project Properties.
 * To change String template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import com.models.SinhvienMonhoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.ConnectDB;
import com.models.ChiTietSV_MH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.ws.rs.PathParam;
 /**
 *
 * @author Man Pham
 */
@Path("ketquahoc")
public class KetQuaHocC {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SinhvienMonhoc> getDataJson() throws ClassNotFoundException, SQLException{
        List <SinhvienMonhoc> listSv = new ArrayList<>();
        ResultSet rs = ConnectDB.getPreparedStatement("SELECT * FROM SINHVIEN_MONHOC").executeQuery();
        while(rs.next())
        {
            SinhvienMonhoc newSvMh = new SinhvienMonhoc(
                    rs.getString("MSSV"),
                    rs.getString("MALOPMH"),
                    getNameLopMH(rs.getString("MALOPMH")),
                    rs.getDouble("DIEMQT"),
                    rs.getDouble("DIEMGK"),
                    rs.getDouble("DIEMTH"),
                    rs.getDouble("DIEMCK"),
                    callProcedure("PROC_IN_MSSV_MAMH",rs.getString("MSSV"),rs.getString("MALOPMH"))
            );
            listSv.add(newSvMh);
        }
        return listSv;
    }
    
    //Tim ten lop hoc dua ma lop
    public String getNameLopMH(String maLopMH){
        String TenLop = null;
        try {
            ResultSet rs = ConnectDB.getPreparedStatement("SELECT * FROM LOPMONHOC WHERE MALOPMH = 'IE204.I32'").executeQuery();
               while(rs.next())
               {
                    TenLop = rs.getNString("TENLOPMH");
               }
               return TenLop;
        } catch (SQLException e) {
            System.out.println("Error: " +e);
            return "Error: " +e;
        }
    }
    
    @GET
    @Path("{mssv}")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<SinhvienMonhoc> find(@PathParam("mssv") String mssv) throws ClassNotFoundException {
            List <SinhvienMonhoc> listSv = new ArrayList<>();
        try {
            ResultSet rs = ConnectDB.getPreparedStatement("SELECT * FROM SINHVIEN_MONHOC WHERE MSSV = "+mssv).executeQuery();
            while(rs.next())
            {
                SinhvienMonhoc newSv = new SinhvienMonhoc(
                   rs.getString("MSSV"),
                    rs.getString("MALOPMH"),
                    getNameLopMH(rs.getString("MALOPMH")),
                    rs.getDouble("DIEMQT"),
                    rs.getDouble("DIEMGK"),
                    rs.getDouble("DIEMTH"),
                    rs.getDouble("DIEMCK"),
                    callProcedure("PROC_IN_MSSV_MAMH",rs.getString("MSSV"),rs.getString("MALOPMH"))
                );
                listSv.add(newSv);
                
                
            }
            return listSv;
        } catch (SQLException e) {
            System.out.println("Error: " +e);
            return null;
        }
    }
    
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ChiTietSV_MH> Test() throws ClassNotFoundException{
        return callProcedure("PROC_IN_MSSV_MAMH","12340001","IE204.I32");
    }
    
    
    
    
    
    public  ArrayList<ChiTietSV_MH> callProcedure(String procName, String mssv,String mlopmh) throws ClassNotFoundException {
        ArrayList <ChiTietSV_MH> dsChiTietSV = new ArrayList<>();
        String SPsql = "EXEC "+procName+" ?,?";
        Connection con = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.makeConnect();   // java.sql.Connection
            ps = con.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(90);
            ps.setString(1,mssv);
            ps.setString(2,mlopmh);
            rs = ps.executeQuery();
            while(rs.next())
            {
                ChiTietSV_MH ctSVMH = new ChiTietSV_MH(rs);
                dsChiTietSV.add(ctSVMH);
            }
            return dsChiTietSV;
        } catch (SQLException se) {
            System.out.println("Error al ejecutar SQL"+ se.getMessage());
            throw new IllegalArgumentException("Error al ejecutar SQL: " + se.getMessage());
        }finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    }

}           