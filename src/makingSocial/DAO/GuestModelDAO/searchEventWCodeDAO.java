package makingSocial.DAO.GuestModelDAO;

import makingSocial.controller.conexionMySQL;
import makingSocial.controller.conexionSingleton;
import makingSocial.model.eventModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class searchEventWCodeDAO {

    public static eventModel buscarEventoPorId(int eventId) {
        String sql = "SELECT id_event, id_host, date, schedule, location, postalcode, dresscode, theme, description1, description2, allowedage, access FROM Event WHERE id_event = ?";

        eventModel event = null;

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, eventId);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    event = new eventModel(
                            rs.getInt("id_event"),
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("schedule").toLocalTime(),
                            rs.getString("location"),
                            rs.getInt("postalcode"),
                            rs.getBoolean("dresscode"),
                            rs.getBoolean("theme"),
                            rs.getString("description1"),
                            rs.getString("description2"),
                            rs.getInt("allowedage"),
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

        return event;
    }
}