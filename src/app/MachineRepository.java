package app;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class MachineRepository {
    private Connection conn;

    public MachineRepository() 
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
    
    public MachineRepository(Connect conn)
    { 
        this.conn = conn.getConnection(); 
    }
    
    public ArrayList<Machine> loadMachines(String filter) throws SQLException {
        if (conn == null) {
            throw new SQLException("Няма връзка с базата данни!");
        }

        ArrayList<Machine> list = new ArrayList<>();
        String sql = "SELECT machineID, type, brand, model, serialNumber, status FROM machines";

        if (filter != null && !filter.isEmpty()) {
            sql += " WHERE " + filter;
        }

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Machine m = new Machine();
                m.setMachineID(rs.getInt("machineID"));
                m.setType(rs.getString("type"));
                m.setBrand(rs.getString("brand"));
                m.setModel(rs.getString("model"));
                m.setSerialNumber(rs.getString("serialNumber"));
                m.setStatus(rs.getString("status"));

                list.add(m);
            }
        }

        return list;
    }
    
    public boolean addMachine(Machine machine) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "INSERT INTO machines (type, brand, model, serialNumber, status) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) 
        {
            stmt.setString(1, machine.getType());
            stmt.setString(2, machine.getBrand());
            stmt.setString(3, machine.getModel());
            stmt.setString(4, machine.getSerialNumber());
            stmt.setString(5, machine.getStatus());

            int rows = stmt.executeUpdate();
            if (rows > 0) 
            {
            
                try (ResultSet rs = stmt.getGeneratedKeys()) 
                {
                    if (rs.next()) 
                    {
                    machine.setMachineID(rs.getInt(1));
                    }
                }
                return true;
            }
            return false;
        }
    }
    
    
    public boolean updateMachine(Machine machine) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "UPDATE machines SET type=?, brand=?, model=?, serialNumber=?, status=? WHERE machineID=?";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            stmt.setString(1, machine.getType());
            stmt.setString(2, machine.getBrand());
            stmt.setString(3, machine.getModel());
            stmt.setString(4, machine.getSerialNumber());
            stmt.setString(5, machine.getStatus());
            stmt.setInt(6, machine.getMachineID());

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }
    
    
    public boolean deleteByID(int id) throws SQLException
    {
        if(conn==null)
        {
            throw new SQLException("няма връзка с базата");
        }
            
        String sql = "DELETE FROM machines WHERE machineID = ?";
        
        int rows = 0;
        try(PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        return rows > 0;
    }
}
