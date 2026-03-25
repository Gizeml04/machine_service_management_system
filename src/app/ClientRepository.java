package app;

import java.sql.*;
import java.util.*;
import java.util.logging.*;


public class ClientRepository {
    private Connection conn;

 
    
    public ClientRepository() 
    {
        try 
        { 
            conn = DriverManager.getConnection("jdbc:sqlite:machine_service.db"); 
        }  
        catch (SQLException e) 
        { 
            System.out.println(e.getMessage()); 
        }
    }
    
    public ClientRepository(Connect conn)
    { 
        this.conn = conn.getConnection(); 
    }
    
    
    public ArrayList<Client> loadClient(String filter) throws SQLException
    {
        if(conn == null)
        {
            throw new SQLException("Няма връзка с базата данни!");
        }
        
        
        
        ArrayList<Client> list = new ArrayList<>();
        
        String sql = "SELECT Client_ID, Client_Name, Address, City, Phone_Number, Email FROM Client";
        
         if(filter.length() > 0){
            sql += " where " + filter;
        }
        
        try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {
            while(rs.next())
            {
                Client e = new Client();
                e.setClientID(rs.getInt("Client_ID"));
                e.setName(rs.getString("Client_Name"));
                e.setAddress(rs.getString("Address"));
                e.setCity(rs.getString("City"));
                e.setPhone(rs.getString("Phone_Number"));
                e.setEmail(rs.getString("Email"));
                
                list.add(e);
            }
        }
        return list;
    }
    
    public boolean deleteByID(int id) throws SQLException
    {
        if(conn==null)
        {
            throw new SQLException(" Няма връзка с базата ");
        }
            
        String sql = "DELETE FROM Client where Client_ID = ?";
        
        int rows = 0;
        try(PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        return rows > 0;
    }
    
    
    public boolean update(Client client) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "UPDATE Client SET Client_Name=?, Address=?, City=?, Phone_Number=?, Email=? WHERE Client_ID=?";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getAddress());
            stmt.setString(3, client.getCity());
            stmt.setString(4, client.getPhone());
            stmt.setString(5, client.getEmail());
            stmt.setInt(6, client.getClientID());

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }
    
    public boolean insert(Client client) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "INSERT INTO Client (Client_Name, Address, City, Phone_Number, Email) VALUES (?, ?, ?, ?, ?)";
    
        try (PreparedStatement stmt = conn.prepareStatement(
        sql, Statement.RETURN_GENERATED_KEYS);) 
        {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getAddress());
            stmt.setString(3, client.getCity());
            stmt.setString(4, client.getPhone());
            stmt.setString(5, client.getEmail());

            int rows = stmt.executeUpdate();
            if (rows > 0) 
            {
                {
                    if (rows>0) 
                    {
                        ResultSet rs = stmt.getGeneratedKeys();
                        if(rs.next()){
                        client.setClientID(rs.getInt(1));}
                    }
                }
                return true;
            }
            return false;
        }  
    }
    
   
}
