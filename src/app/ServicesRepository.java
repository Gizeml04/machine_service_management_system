package app;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class ServicesRepository {
    private Connection conn;
    
    public ServicesRepository()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:machine_service.db");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public ServicesRepository(Connect conn)
    {
        this.conn = conn.getConnection();
    }
    
    
    public ArrayList<Services> loadServices(String filter) throws SQLException
    {
        if(conn == null)
        {
            throw new SQLException("Няма връзка с базата данни!");
        }
        
        ArrayList<Services> list = new ArrayList<>();
        
        String sql = "SELECT serviceID, name, type,price FROM services";
        
        if(filter.length() > 0)
        {
            sql += " where " + filter;
        }
        
        try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {
            while(rs.next())
            {
                Services s = new Services();
                s.setServiceID(rs.getInt("serviceID"));
                s.setName(rs.getString("name"));
                s.setType(rs.getString("type"));
                s.setPrice(rs.getString("price"));
                
                list.add(s);
            }
        }
        return list;
    }
}
