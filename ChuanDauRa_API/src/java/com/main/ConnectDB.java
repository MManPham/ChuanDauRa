/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Man Pham
 */
public class ConnectDB {
    
    private static final String DB_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=DATABASENAME";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "123";

    
    
    public static  Connection  makeConnect() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
		try {
			// load the Driver Class
			Class.forName(DB_DRIVER_CLASS);

			// create the connection now
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
                    System.out.println("Error: "+e);
		}
		return con;
        
    }
    
    public static PreparedStatement getPreparedStatement(String query)
    {
        PreparedStatement ps = null;
        try {
            Connection con = ConnectDB.makeConnect();
            ps = con.prepareStatement(query);
            
            return ps;
        } catch (ClassNotFoundException| SQLException e) {
            System.out.println("Error: " +e);
            return null;
        }
    }

    public static Connection getPreparedStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PreparedStatement prepareStatement(String SPsql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}


