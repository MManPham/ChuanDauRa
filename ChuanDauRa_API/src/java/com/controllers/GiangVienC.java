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
import com.models.GiangVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.main.ConnectDB;
import com.models.CDR_KH_KQ;
import com.models.CDR_MH;
import com.models.ListCDR_MH;
import com.models.Lop_CN;
import com.models.Lop_MH;
import com.models.Sinhvien;
import com.models.SinhvienMonhoc;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 *
 * @author Hayama
 */
@Path("giangvien")
public class GiangVienC {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<GiangVien> getAllSV() throws ClassNotFoundException, SQLException {
        ArrayList<GiangVien> listGv = new ArrayList<>();

        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM GIANGVIEN").executeQuery();
            while (rs.next()) {
                GiangVien newGv = new GiangVien(
                        rs.getString("MSGV"),
                        rs.getString("TENGV")
                );
                listGv.add(newGv);

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
    public GiangVien findGV(@PathParam("id") String id) throws ClassNotFoundException {
        GiangVien newGv = null;
        Connection con = null;
        ResultSet rs = null;
        List<Lop_MH> danhSachLopMonHoc = new ArrayList<>();
        List<Lop_CN> danhSachLopChuNhiem = new ArrayList<>();
        
        String tenGV = null;
        String maGV = null;
        try {
            con = ConnectDB.makeConnect();
                rs = con.prepareStatement("SELECT GIANGVIEN.MSGV, GIANGVIEN.TENGV, LOPMONHOC.TENLOPMH,LOPMONHOC.MALOPMH  \n"
                        + "FROM LOPMONHOC, GIANGVIEN \n"
                        + "WHERE LOPMONHOC.MSGV = '" + id + "' AND LOPMONHOC.MSGV = GIANGVIEN.MSGV").executeQuery();
                while (rs.next()) {
                    maGV = rs.getString("MSGV");
                    tenGV = rs.getString("TENGV");
                    danhSachLopMonHoc.add(new Lop_MH(rs.getString("TENLOPMH"),rs.getString("MALOPMH"), this.getSVs_inClassMH(rs.getString("MALOPMH"))));
                }
                
                
                rs = con.prepareStatement("SELECT * FROM LOPSINHHOAT WHERE MACOVAN = '"+id+"'").executeQuery();
                while(rs.next()){
                    String maLopSH = rs.getString("MALOPSH");
                    danhSachLopChuNhiem.add(new Lop_CN(maLopSH, getSVs_inClassCN(maLopSH)));
                }
            newGv = new GiangVien(maGV, tenGV, danhSachLopMonHoc.isEmpty()?null:danhSachLopMonHoc,danhSachLopChuNhiem);
            return newGv;
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

    public List<SinhvienMonhoc> getSVs_inClassMH(String maLop) throws ClassNotFoundException, SQLException {
        List<SinhvienMonhoc> listSv = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        SinhVienC sv_C = new SinhVienC();

        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT SVMH.MSSV,TENSV,MONHOC.MAMH,LOPMONHOC.TENLOPMH,LOPMONHOC.MALOPMH,SVMH.DIEMQT,SVMH.DIEMGK,SVMH.DIEMTH,SVMH.DIEMCK,MONHOC.TINCHI\n"
                    + "FROM SINHVIEN_MONHOC SVMH, MONHOC,LOPMONHOC , SINHVIEN\n"
                    + "WHERE SVMH.MALOPMH= LOPMONHOC.MALOPMH AND LOPMONHOC.MAMON = MONHOC.MAMH\n"
                    + "	AND LOPMONHOC.MALOPMH = '" + maLop + "' AND SINHVIEN.MSSV = SVMH.MSSV").executeQuery();
            while (rs.next()) {
                SinhvienMonhoc newSvMh = new SinhvienMonhoc(
                        rs.getString("MSSV"),
                        rs.getString("TENSV"),
                        rs.getDouble("DIEMQT"),
                        rs.getDouble("DIEMGK"),
                        rs.getDouble("DIEMTH"),
                        rs.getDouble("DIEMCK"),
                        sv_C.getCDR_MH(rs.getString("MSSV"), rs.getString("MAMH"))
                );
                listSv.add(newSvMh);
            }
            return listSv;
        } catch (Exception e) {
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

    public List<Sinhvien> getSVs_inClassCN(String maLop) throws ClassNotFoundException, SQLException {
        List<Sinhvien> listSv = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        SinhVienC sv_C = new SinhVienC();

        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM SINHVIEN WHERE MALOPSH = '"+ maLop +"'").executeQuery();
            while (rs.next()) {
                Sinhvien newSvSh = new Sinhvien(
                        rs.getString("MSSV"),
                        rs.getString("TENSV"),
                        rs.getString("SODT"),
                        rs.getString("NIENKHOA"),
                        rs.getString("PASSW"),
                        rs.getString("MACHUYENNGANH"),
                        sv_C.get_CDR_KH(rs.getString("MACHUYENNGANH"), sv_C.getListCDR_MH(rs.getString("MSSV"))),
                        sv_C.getListCDR_LopMH(rs.getString("MSSV"))
                );
                listSv.add(newSvSh);
            }
            return listSv;
        } catch (Exception e) {
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





