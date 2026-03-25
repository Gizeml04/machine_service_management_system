package app;

import java.sql.*;
import java.util.*;

public class DeliveryRepository {

    public void addDelivery(int clientId, int machineId, String date) throws SQLException {
        String sql = "INSERT INTO Delivery (Client_ID, machineID, Delivery_date) VALUES (?, ?, ?)";

        Connect c = new Connect();
        Connection con = c.getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, clientId);
            ps.setInt(2, machineId);
            ps.setString(3, date);
            ps.executeUpdate();
        }
    }

    public List<Machine> getMachinesForClient(int clientId) throws SQLException {
        String sql = """
            SELECT m.*
            FROM Delivery d
            JOIN machines m ON m.machineID = d.machineID
            WHERE d.Client_ID = ?
        """;

        List<Machine> list = new ArrayList<>();
        Connect c = new Connect();
        Connection con = c.getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, clientId);
            try (ResultSet rs = ps.executeQuery()) {
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
        }
        return list;
    }
}
