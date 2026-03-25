package app;

import java.sql.*;
import java.util.*;
import java.util.logging.*;


public class EmployeeRepository {
    private Connection conn;

    public EmployeeRepository() 
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
    
    public EmployeeRepository(Connect conn)
    { 
        this.conn = conn.getConnection(); 
    }
    
    
    public ArrayList<Employee> loadEmployee(String filter) throws SQLException
    {
        if(conn == null)
        {
            throw new SQLException("Няма връзка с базата данни!");
        }
        
        ArrayList<Employee> list = new ArrayList<>();
        
        String sql = "SELECT employeeID, employeeName, address, city, position, phone, email FROM Employees";
        
        try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {
            while(rs.next())
            {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("employeeID"));
                e.setName(rs.getString("employeeName"));
                e.setAddress(rs.getString("address"));
                e.setCity(rs.getString("city"));
                e.setPosition(rs.getString("position"));
                e.setPhone(rs.getString("phone"));
                e.setEmail(rs.getString("email"));
                
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
            
        String sql = "DELETE FROM Employees where employeeid = ?";
        
        int rows = 0;
        try(PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        return rows > 0;
    }
             
    public boolean addEmployee(Employee employee) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "INSERT INTO Employees (employeeName, address, city, position, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getAddress());
            stmt.setString(3, employee.getCity());
            stmt.setString(4, employee.getPosition());
            stmt.setString(5, employee.getPhone());
            stmt.setString(6, employee.getEmail());

            int rows = stmt.executeUpdate();
            if (rows > 0) 
            {
            
                try (ResultSet rs = stmt.getGeneratedKeys()) 
                {
                    if (rs.next()) 
                    {
                        employee.setEmployeeID(rs.getInt(1));
                    }
                }
                return true;
            }
            return false;
        }  
    }
    
    
    public boolean updateEmployee(Employee employee) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "UPDATE Employees SET employeeName=?, address=?, city=?, position=?, phone=?, email=? WHERE employeeID=?";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getAddress());
            stmt.setString(3, employee.getCity());
            stmt.setString(4, employee.getPosition());
            stmt.setString(5, employee.getPhone());
            stmt.setString(6, employee.getEmail());
            stmt.setInt(7, employee.getEmployeeID());

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }
}
    
    

