package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    public List<Object[]> getPaymentsForClient(int clientId) throws SQLException {

    String sql = """
        SELECT 
            p.Payment_ID,
            s.type AS ServiceType,
            m.brand || ' ' || m.model AS Machine,
            p.Amount,
            p.Payment_Date,
            p.Status
        FROM Payment p
        JOIN machines m ON m.machineID = p.machineID
        JOIN services s ON s.serviceID = p.serviceID
        WHERE p.Client_ID = ?
    """;

    List<Object[]> list = new ArrayList<>();

    Connect c = new Connect();
    Connection con = c.getConnection();

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, clientId);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Object[]{
                    rs.getInt("Payment_ID"),
                    rs.getString("ServiceType"),
                    rs.getString("Machine"),
                    rs.getDouble("Amount"),
                    rs.getString("Payment_Date"),
                    rs.getString("Status")
                });
            }
        }
    }
    return list;
}


    public void payMyPayment(int paymentId, int clientId) throws SQLException {

        String sql = """
            UPDATE Payment
            SET Status = 'Платена',
                Payment_Date = date('now')
            WHERE Payment_ID = ?
              AND Client_ID = ?
              AND Status = 'Неплатена'
        """;

        Connect c = new Connect();
        Connection con = c.getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, paymentId);
            ps.setInt(2, clientId);
            ps.executeUpdate();
        }
    }
}
