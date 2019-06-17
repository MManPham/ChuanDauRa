/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.main.ConnectDB;
import com.models.CDR_KH_KQ;
import com.models.testCDR_MH;
import com.models.testListCDR_MH;
import com.models.testSinhVien;
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
@Path("testsinhvien")
public class testSinhVienC {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<testSinhVien> getAllSV() throws ClassNotFoundException, SQLException {
        ArrayList<testSinhVien> listSv = new ArrayList<>();
        
        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM SINHVIEN").executeQuery();
            while (rs.next()) {
                testSinhVien newSv = new testSinhVien(
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
    public testSinhVien findSV(@PathParam("id") String id) throws ClassNotFoundException {
        testSinhVien newSv = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM SINHVIEN WHERE MSSV = " + id).executeQuery();
            while (rs.next()) {
                newSv = new testSinhVien(
                        rs.getString("MSSV"),
                        rs.getString("TENSV"),
                        rs.getString("SODT"),
                        rs.getString("NIENKHOA"),
                        rs.getString("PASSW"),
                        rs.getString("MACHUYENNGANH"),
                        get_CDR_KH(rs.getString("MACHUYENNGANH"), getListCDR_MH(rs.getString("MSSV"))),
                        getListCDR_LopMH(rs.getString("MSSV"))
                        
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


    public List<CDR_KH_KQ> get_CDR_KH(String maCN,ArrayList<testListCDR_MH> danhSachMonHoc ) throws ClassNotFoundException {
     
        Connection con = null;
        ResultSet rs = null;
        List<CDR_KH_KQ> list_cdr = new ArrayList<>();
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM CDR_CN WHERE MACHUYENNGANH ='"+maCN+"'").executeQuery();
            while (rs.next()) {
                
                list_cdr.add(new CDR_KH_KQ(rs.getString("CDRKH"), getValueOfCDRKhoaHoc(rs.getString("CDRKH"), danhSachMonHoc)));
                
            }
            return  list_cdr;
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
    
    public ArrayList<testListCDR_MH> getListCDR_MH(String mssv) throws ClassNotFoundException{
       
        Connection con = null;
        ResultSet rs = null;
        ArrayList<testListCDR_MH> DanhSachMonHoc = new ArrayList<>();
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT DISTINCT MAMH FROM KETQUATHI WHERE MSSV = '" + mssv + "'").executeQuery();
            while (rs.next()) {
                List<testCDR_MH> list_cdrmh = new ArrayList<>(getCDR_MH(mssv,rs.getString("MAMH")));
                testListCDR_MH temp = new testListCDR_MH(rs.getString("MAMH"),list_cdrmh);
                DanhSachMonHoc.add(temp);
            
               
            }
            
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
        
        return DanhSachMonHoc;
    }
    
        public ArrayList<testListCDR_MH> getListCDR_LopMH(String mssv) throws ClassNotFoundException{
       
        Connection con = null;
        ResultSet rs = null;
        ArrayList<testListCDR_MH> DanhSachMonHoc = new ArrayList<>();
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT DISTINCT KETQUATHI.MAMH, LOPMONHOC.MALOPMH \n" +
                                        "FROM KETQUATHI, LOPMONHOC \n" +
                                        "WHERE KETQUATHI.MAMH =  LOPMONHOC.MAMON AND MSSV = '" + mssv + "'").executeQuery();
            while (rs.next()) {
                List<testCDR_MH> list_cdrmh = new ArrayList<>(getCDR_MH(mssv,rs.getString("MAMH")));
                testListCDR_MH temp = new testListCDR_MH(rs.getString("MALOPMH"),list_cdrmh);
                DanhSachMonHoc.add(temp);
            
               
            }
            
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
        
        return DanhSachMonHoc;
    } 
        
    public List<testCDR_MH> getCDR_MH(String mssv, String maMon) throws ClassNotFoundException{
      
        Connection con = null;
        ResultSet rs = null;
        
        List<testCDR_MH> list_cdrmh = new ArrayList<>();
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT DISTINCT CDRMH FROM CDR_MH WHERE MAMH = '"+maMon+"'").executeQuery();
            while (rs.next()) {
                
                float ketqua = getValueOfCDRMH(mssv,maMon, rs.getString(1));
                String tempCDR_MH = rs.getString("CDRMH");
                List<CDR_KH_KQ> temp = new ArrayList<>(getChuanDauRaKhoaHocCuaMotMon(maMon,tempCDR_MH, ketqua));
                list_cdrmh.add(new testCDR_MH(tempCDR_MH, ketqua, temp));
                // list_cdrmh.add(new testCDR_MH(rs.getString(1), getValueOfCDRMH(mssv,maMon, rs.getString(1))));
            }
            
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
        
        return list_cdrmh;
    }
    
    public float getValueOfCDRMH(String mssv, String maMon, String CDRMH) throws ClassNotFoundException{
        
        Connection con = null;
        ResultSet rs = null;        
        float result = 0;
        int  count = 0;
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT KQT.CAU, KQT.DIEM, CTDT.DIEMTOIDA, DT.LOAI, CTDT.CDR " +
                                        "FROM KETQUATHI KQT, DETHI DT, CAUTRUCDT CTDT " +
                                        "WHERE KQT.MADT = DT.MADT AND DT.MADT =  CTDT.MADT AND CTDT.CAU = KQT.CAU "
                                        + "AND KQT.MSSV = '"+mssv+"' AND DT.MAMH ='"+maMon+"' AND CTDT.CDR = '"+CDRMH+"'")
                                        .executeQuery();
            while (rs.next()) {
                
                
                int tempCount = getNumberOfCDRMH(maMon, rs.getString("LOAI"),CDRMH);
                result += (float)(rs.getInt("DIEM")*100/rs.getInt("DIEMTOIDA"))/tempCount;
                count ++;
            }
            if(count == 0) return 0;            
            result /= count;
            return result;
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return 0;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }

      
    }
            
    public int getNumberOfCDRMH(String maMon, String loai, String CDRMH) throws ClassNotFoundException{
        Connection con = null;
        ResultSet rs = null;
        int result = 1;
        try {
            con = ConnectDB.makeConnect();
            rs =  con.prepareStatement("SELECT  COUNT(*) " +
                                        "FROM CAUTRUCDT CTDT, DETHI DT " +
                                        "WHERE CTDT.MADT = DT.MADT AND DT.LOAI = '"+ loai +"' AND DT.MAMH = '"+maMon+"' AND CDR = '"+CDRMH+"'")                                     
                                        .executeQuery();
            rs.next();
            result = rs.getInt(1);
            
            return result;
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return result;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }
    }
    
    
    
    public float getValueOfCDRKhoaHoc(String CDR_KH, ArrayList<testListCDR_MH> danhSachMonHoc) throws ClassNotFoundException{
        float result = 0;
        Connection con = null;
        ResultSet rs = null;
        int count  = 0;
        try {
            con = ConnectDB.makeConnect();
            rs =  con.prepareStatement("SELECT * FROM CDR_MH WHERE CDRKH = '"+ CDR_KH +"'")                                     
                                        .executeQuery();
            while( rs.next()){
                for(testListCDR_MH x : danhSachMonHoc){
                    if(x.getMaMon().equals(rs.getString("MAMH")))
                    {
                        int numberCDRMHofKH = countCDRKHofMonHoc(x.getMaMon(), CDR_KH);
                        for(testCDR_MH y : x.getDanhSach_CDR_CN() ){
                            if(y.getChuanDauRaMonHoc().equals(rs.getString("CDRMH"))){
                                result += y.getKetQua()/numberCDRMHofKH;
                                
                            }                                    
                        }
                        count ++;
                        
                    }
                }
//                    for(int i = 0; i < danhSachMonHoc.size(); i++){
//                        if(danhSachMonHoc.get(i).getMaMon().equals(rs.getString("MAMH"))){
//                            int numberCDRMHofKH = countCDRKHofMonHoc(danhSachMonHoc.get(i).getMaMon(), CDR_KH);
//                            for(int j = 0; j < danhSachMonHoc.get(i).getDanhSach_CDR_CN().size(); j++){
//                                if(danhSachMonHoc.get(i).getDanhSach_CDR_CN().get(j).getChuanDauRaMonHoc().equals(rs.getString("CDRMH"))){
//                                    float temp = danhSachMonHoc.get(i).getDanhSach_CDR_CN().get(j).getKetQua()/numberCDRMHofKH;
//                                    result += temp;
//                                    
//                                    danhSachMonHoc.get(i).getDanhSach_CDR_CN().get(j).addCDR_KH(CDR_KH, temp);
//                                    
//                                }
//                                
//                            }
//                            count ++;
//                        }
//                    }

            }
        if (count == 0) return 0;
        return result/(float)count;
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return result;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }                                    
    }    
    public int countCDRKHofMonHoc(String maMon, String CDRKH) throws ClassNotFoundException{
        int result = 0;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            con = ConnectDB.makeConnect();
            rs =  con.prepareStatement("SELECT  COUNT(*) AS TOTAL " +
                                        "FROM CDR_MH " +
                                        "WHERE CDR_MH.MAMH = '"+ maMon+"' AND CDRKH = '"+ CDRKH +"' " +
                                        "GROUP BY CDRKH")                                     
                                        .executeQuery();
            while( rs.next()){
               result = rs.getInt("TOTAL");
            }
            
            return result;
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return result;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }  
    }
        public ArrayList<CDR_KH_KQ> getChuanDauRaKhoaHocCuaMotMon(String maMon ,String CDR_MH, float ketqua) throws ClassNotFoundException{
        int count = 0;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<CDR_KH_KQ> chuanDauRaKhoaHoc = new ArrayList<>();
        try {
            con = ConnectDB.makeConnect();
            rs =  con.prepareStatement("SELECT MAMH, CDRMH, CDRKH " +
                                        "FROM CDR_MH " +
                                        "WHERE MAMH = '"+ maMon +"' AND CDRMH = '"+ CDR_MH +"'")                                     
                                        .executeQuery();
            while( rs.next()){
               String CDRKH = rs.getString("CDRKH");
               count = countCDRKHofMonHoc(maMon, CDRKH);
               chuanDauRaKhoaHoc.add(new CDR_KH_KQ(CDRKH, ketqua/count));
            }
            
            return chuanDauRaKhoaHoc;
            
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
