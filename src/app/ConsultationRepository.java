package app;

import java.sql.*;
import java.util.*;
import java.util.logging.*;


public class ConsultationRepository {
    private Connection conn;

 
    
    public ConsultationRepository() 
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
    
    public ConsultationRepository(Connect conn)
    { 
        this.conn = conn.getConnection(); 
    }
    
    
    public ArrayList<Consultation> loadConsultation(String filter) throws SQLException
    {
        if(conn == null)
        {
            throw new SQLException("Няма връзка с базата данни!");
        }
        
        ArrayList<Consultation> list = new ArrayList<>();
        
        String sql = "SELECT consultation_id, machine_type, brand, model, consultation_date, consultation_type FROM Consultations";
        
        if(filter.length() > 0){
            sql += " where " + filter;
        }
        
        try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {
            while(rs.next())
            {
                Consultation e = new Consultation();
                e.setConsultationID(rs.getInt("consultation_id"));
                e.setMachine_type(rs.getString("machine_type"));
                e.setBrand(rs.getString("brand"));
                e.setModel(rs.getString("model"));
                e.setConsultation_date(rs.getString("consultation_date"));
                e.setConsultation_type(rs.getString("consultation_type"));        
                
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
            
        String sql = "DELETE FROM Consultations where consultation_id = ?";
        
        int rows = 0;
        try(PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        return rows > 0;
    }
    
    public boolean insertConsultation(Consultation consultation) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "INSERT INTO Consultations (machine_type, brand, model, consultation_date, consultation_type) VALUES (?, ?, ?, ?, ?)";
    
        try (PreparedStatement stmt = conn.prepareStatement(
        sql, Statement.RETURN_GENERATED_KEYS);) 
        {
            stmt.setString(1, consultation.getMachine_type());
            stmt.setString(2, consultation.getBrand());
            stmt.setString(3, consultation.getModel());
            stmt.setString(4, consultation.getConsultation_date());
            stmt.setString(5, consultation.getConsultation_type());

            int rows = stmt.executeUpdate();
            if (rows > 0) 
            {
                {
                    if (rows>0) 
                    {
                        ResultSet rs = stmt.getGeneratedKeys();
                        if(rs.next()){
                        consultation.setConsultationID(rs.getInt(1));}
                    }
                }
                return true;
            }
            return false;
        }  
    }
    
    public boolean updateConsultation(Consultation consultation) throws SQLException 
    {
        if (conn == null) 
        {
            throw new SQLException("Няма връзка с базата данни!");
        }

        String sql = "UPDATE Consultations SET machine_type=?, brand=?, model=?, consultation_date=?, consultation_type=? WHERE consultation_id=?";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            stmt.setString(1, consultation.getMachine_type());
            stmt.setString(2, consultation.getBrand());
            stmt.setString(3, consultation.getModel());
            stmt.setString(4, consultation.getConsultation_date());
            stmt.setString(5, consultation.getConsultation_type());
            stmt.setInt(6, consultation.getConsultationID());

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }
}