package app;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Connect {
    
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    
    public Connect(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:machine_service.db");
            Statement st = conn.createStatement();
            st.execute("PRAGMA foreign_keys = ON");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public Connection getConnection(){
        return conn;
    }
    public void select(){
        
        String sql = "SELECT Employee_Name FROM Employees";
        
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
               System.out.println(rs.getString("FirstName") + "\t" + rs.getString("LastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void close(){
        try 
        {
            if (conn != null) 
            {
                conn.close();
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        } 
        catch (Throwable ex) 
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
