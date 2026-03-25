
package app;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class RepairRepository {
    private Connection conn;
    



public RepairRepository() 
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
    
    public RepairRepository(Connect conn)
    { 
        this.conn = conn.getConnection(); 
    }
    
    
    public ArrayList<Repair> loadRepair(String filter) throws SQLException
    {
        if(conn == null)
        {
            throw new SQLException("Няма връзка с базата данни!");
        }
        
        
        
        ArrayList<Repair> list = new ArrayList<>();
        
        String sql = "SELECT repair_id, machine_type, brand, model, repair_date, repair_type FROM Repairs";
        
         if(filter.length() > 0){
            sql += " where " + filter;
        }
        
        try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {
            while(rs.next())
            {
                Repair e = new Repair();
                e.setRepairID(rs.getInt("repair_id"));
                e.setMachine_type(rs.getString("machine_type"));
                e.setBrand(rs.getString("brand"));
                e.setModel(rs.getString("model"));
                e.setRepair_date(rs.getString("repair_date"));
                e.setRepair_type(rs.getString("repair_type"));
                
                list.add(e);
            }
        }
        return list;
    }
    
    public boolean deleteByID(int id) throws SQLException
    {
        if(conn==null)
        {
            throw new SQLException("няма връзка с базата");
        }
            
        String sql = "DELETE FROM Repairs where repair_id = ?";
        
        int rows = 0;
        try(PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        return rows > 0;
    }
    
    
    public boolean updateRepair(Repair repair) throws SQLException{
        if(conn==null)
        {
            throw new SQLException("няма връзка с базата");
        }
        int rows = 0;
        String sql = "UPDATE Repairs SET machine_type = ?, brand = ?, model = ?, repair_date = ?, repair_type = ? where repair_id = ?";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, repair.getMachine_type());
            stmt.setString(2, repair.getBrand());
            stmt.setString(3, repair.getModel());
            stmt.setString(4, repair.getRepair_date());
            stmt.setString(5, repair.getRepair_type());
            stmt.setInt(6, repair.getRepairID());

            
            rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        return rows > 0;
    }
    
    public boolean insertRepair(Repair repair) throws SQLException{
        if(conn==null)
        {
            throw new SQLException("няма връзка с базата");
        }
        

        String sql = "INSERT INTO Repairs ( machine_type, brand, model, repair_date, repair_type ) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {

            stmt.setString(1, repair.getMachine_type());
            stmt.setString(2, repair.getBrand());
            stmt.setString(3, repair.getModel());
            stmt.setString(4, repair.getRepair_date());
            stmt.setString(5, repair.getRepair_type());

            int  rows = stmt.executeUpdate();
            if (rows > 0) 
            {
            
                try (ResultSet rs = stmt.getGeneratedKeys()) 
                {
                    if (rs.next()) 
                    {
                        repair.setRepairID(rs.getInt(1));
                    }
                }
                return true;
            }
            return false;
        }
       
    }
    
   
}
