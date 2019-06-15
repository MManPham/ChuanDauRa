/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.main.ConnectDB;
import com.models.CDR_KH_KQ;
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
    
        @GET
    @Path("{id}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CDR_KH_KQ> getAVGYear(@PathParam("id") String id, @PathParam("year") int year) throws ClassNotFoundException {
        Connection con = null;
        ResultSet rs = null;

        SinhVienC Sinhvien = new SinhVienC();
        int count = 0;
        List<CDR_KH_KQ> danhSachChuanDauRa = null;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT SINHVIEN.MSSV\n"
                    + "FROM SINHVIEN, KHOA, CHUYENNGANH "
                    + "WHERE SINHVIEN.MACHUYENNGANH = CHUYENNGANH.MACHUYENNGANH AND CHUYENNGANH.MAKHOA = KHOA.MAKHOA AND "
                    + "MATRUONGKHOA = '" + id + "' AND SINHVIEN.NIENKHOA = '" + year + "'").executeQuery();

            while (rs.next()) {
                List<CDR_KH_KQ> temp = new ArrayList<>(Sinhvien.findSV(rs.getString("MSSV")).getChuanDauRA_KH());
                if (danhSachChuanDauRa == null) {
                    danhSachChuanDauRa = new ArrayList<>(temp);
                } else {
                    for (CDR_KH_KQ x : temp) {
                        for (int i = 0; i < danhSachChuanDauRa.size(); i++) {
                            if (x.getChuanDaura().equals(danhSachChuanDauRa.get(i).getChuanDaura())) {
                                danhSachChuanDauRa.get(i).setKetQua(danhSachChuanDauRa.get(i).getKetQua() + x.getKetQua());
                            }
                        }
                    }
                }
                count++;
            }

            for (int i = 0; i < danhSachChuanDauRa.size(); i++) {
                danhSachChuanDauRa.get(i).setKetQua(danhSachChuanDauRa.get(i).getKetQua() / count);
            }

            return danhSachChuanDauRa;

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
