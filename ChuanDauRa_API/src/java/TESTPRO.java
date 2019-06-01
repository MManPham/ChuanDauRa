
import com.main.ConnectDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.derby.client.am.Types;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Man Pham
 */
public class TESTPRO {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String userName="sa";
        String password="123";
        con=DriverManager.getConnection("jdbc:sqlserver://localhost\\MISASME2017:1433;databaseName=DATABASENAME",userName,password);
        
        CallableStatement cst = con.prepareCall("{CALL PROC_IN_MSSV_MAMH(?,?)}");
        
        cst.registerOutParameter(2, Types.VARCHAR);
        
        cst.setString("12340001", "IE204.I32");
        
        cst.execute();
        
        String res = cst.getString("MADT");
        
        System.out.println("res");
        
        cst.close();
        con.close();
    }
}
