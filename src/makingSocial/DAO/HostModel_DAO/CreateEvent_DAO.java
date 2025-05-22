package makingSocial.DAO.HostModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateEvent_DAO {
    public boolean ejecutarInsertDeleteUpdate(EventModel newEvent) {
        String sql = "INSERT INTO Event (date, schedule, location, PostalCode, dressCode, theme, description1, description2, allowedAge, access) VALUES (?, ?, ?, ?, ?,?,?,?,?)";


        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, newEvent.getDate());
                stmt.setString(2, newEvent.getSchedule());
                stmt.setString(3, newEvent.getLocation());
                stmt.setInt(4, newEvent.getPostalCode());
                stmt.setBoolean(5, newEvent.getDressCode());

                stmt.executeUpdate();

                return true;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}