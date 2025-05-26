package makingSocial.DAO.HostModelDAO;

import makingSocial.controller.conexionMySQL;
import makingSocial.controller.conexionSingleton;
import makingSocial.model.eventModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class printCodeDAO {
    public static eventModel getEventById(int idEvent) {
        String sql = "SELECT * FROM Event WHERE id_event = ?";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idEvent);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return new eventModel(
                            rs.getInt("id_event"),
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("schedule").toLocalTime(),
                            rs.getString("location"),
                            rs.getInt("postalCode"),
                            rs.getBoolean("dressCode"),
                            rs.getBoolean("theme"),
                            rs.getString("description1"),
                            rs.getString("description2"),
                            rs.getInt("allowedAge"),
                            rs.getBoolean("access"),
                            rs.getInt("id_host")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }
}
