/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.main.ConnectDB;
import com.models.GiangVien;
import com.models.Lop_CN;
import com.models.Lop_MH;
import com.models.NhaQuanLy;
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
@Path("nhaquanly")
public class NhaQuanLyC {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<NhaQuanLy> getAllNQL() throws ClassNotFoundException, SQLException {
        ArrayList<NhaQuanLy> listGv = new ArrayList<>();

        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM KHOA, GIANGVIEN WHERE KHOA.MATRUONGKHOA = GIANGVIEN.MSGV").executeQuery();
            while (rs.next()) {
                String maNhaQuanLy = rs.getString("MATRUONGKHOA");
                String tenNhaQuanLy = rs.getString("TENGV");
                String maKhoa = rs.getString("MAKHOA");
                NhaQuanLy newNQL = new NhaQuanLy(
                    maNhaQuanLy,
                    tenNhaQuanLy,
                    maKhoa
                );
                listGv.add(newNQL);

            }
            return listGv;

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
    public NhaQuanLy findNQL(@PathParam("id") String id) throws ClassNotFoundException {        
        Connection con = null;
        ResultSet rs = null;
        List<GiangVien> danhSachGiangVien = new ArrayList<>();
        String maTruongKhoa = null;
        String tenTruongKhoa = null;
        String maKhoa = null;
        GiangVienC giangVienC = new GiangVienC();
        try {
            con = ConnectDB.makeConnect();
                rs = con.prepareStatement("SELECT * FROM KHOA,GIANGVIEN WHERE MATRUONGKHOA = '"+id+"' AND MSGV = '"+id+"'").executeQuery();
                
                while (rs.next()) {
                   maTruongKhoa = rs.getString("MATRUONGKHOA");
                   tenTruongKhoa = rs.getString("TENGV");
                   maKhoa = rs.getString("MAKHOA");
                }
                if(maTruongKhoa == null) {
                    return null;
                }
                rs = con.prepareStatement("SELECT * FROM GIANGVIEN WHERE MAKHOA = '"+maKhoa+"'").executeQuery();
                while(rs.next()){
                    danhSachGiangVien.add(giangVienC.findGV(rs.getString("MSGV")));
                }
                NhaQuanLy nhaQuanLy = new NhaQuanLy(maKhoa, tenTruongKhoa, maKhoa, danhSachGiangVien);
                
            return nhaQuanLy;
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
