/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.main.ConnectDB;
import com.models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Man Pham
 */
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountC {

    @POST
    @Path("/sinhvien")
    public Response  checkLoginSV(Account account) throws ClassNotFoundException {
        Connection con = null;
        ResultSet rs = null;

        if (account.getId().isEmpty() || account.getPassword().isEmpty()) {
            return Response.serverError().entity("Tài khoản hay mật khẩu không có dữ liệu").build();
        }
        Account resAccount = new Account("", "");
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM SINHVIEN WHERE MSSV = '" + account.getId() + "' AND  PASSW = '" + account.getPassword() + "'").executeQuery();

            while (rs.next()) {
                resAccount.setId(rs.getString("MSSV"));
                resAccount.setPassword(rs.getNString("PASSW"));
            }
            if(resAccount.getId().isEmpty())
            {
                return Response.status(Response.Status.NOT_FOUND).entity("Không tồn tại tài khoản này").build();
            }
             return Response.ok(resAccount, MediaType.APPLICATION_JSON).build();
        } catch (SQLException se) {
            System.out.println("Error al ejecutar SQL" + se.getMessage());
            throw new IllegalArgumentException("Error al ejecutar SQL: " + se.getMessage());
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
            }
        }
    }
    
   
    
    @POST
    @Path("/giaovien")
    public Response  checkLoginGV(Account account) throws ClassNotFoundException {
        Connection con = null;
        ResultSet rs = null;

        if (account.getId().isEmpty() || account.getPassword().isEmpty()) {
            return Response.serverError().entity("Tài khoản hay mật khẩu không có dữ liệu").build();
        }
        Account resAccount = new Account("", "");
        try {
            con = ConnectDB.makeConnect();
            rs = con.prepareStatement("SELECT * FROM GIANGVIEN WHERE MSGV = '" + account.getId() + "' AND  PASSW = '" + account.getPassword() + "'").executeQuery();

            while (rs.next()) {
                resAccount.setId(rs.getString("MSGV"));
                resAccount.setPassword(rs.getNString("PASSW"));
            }
            if(resAccount.getId().isEmpty())
            {   
                return Response.status(Response.Status.NOT_FOUND).entity("Không tồn tại tài khoản này").build();
            }
            if(checkNhaQuanLy(resAccount.getId()))
                resAccount.setIsTruongKhoa(true);
            else  resAccount.setIsTruongKhoa(false);
            return Response.ok(resAccount, MediaType.APPLICATION_JSON).build();
            
        } catch (SQLException se) {
            System.out.println("Error al ejecutar SQL " + se.getMessage());
            throw new IllegalArgumentException("Error al ejecutar SQL: " + se.getMessage());
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public Boolean checkNhaQuanLy(String msgv)
    {
        Connection con = null;
        ResultSet res = null;
        
        try {
            con = ConnectDB.makeConnect();
            res = con.prepareStatement("SELECT * FROM KHOA WHERE MATRUONGKHOA = '"+msgv+"'" ).executeQuery();
            String resMsGV = null;
            while(res.next())
            {
                return true;
            }
                return false;
        } catch (ClassNotFoundException | SQLException se) {
            System.out.println("Error al ejecutar SQL " + se.getMessage());
            throw new IllegalArgumentException("Errors al ejecutar SQL: " + se.getMessage());
        }
        finally {
            try {
                res.close();
                con.close();
            } catch (SQLException ex) {
            }
        }
    }
}




























