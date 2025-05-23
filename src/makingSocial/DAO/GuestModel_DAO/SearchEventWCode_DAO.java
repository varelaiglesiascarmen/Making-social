package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEventWCode_DAO {

    public static EventModel buscarEventoPorId(int eventId) {
        String sql = "SELECT date, schedule, location, postalcode, dresscode, theme, description1, description2, allowedage, access FROM event WHERE id_event = ?";

        EventModel event = null;

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, eventId);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    event = new EventModel(
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("schedule").toLocalTime(),
                            rs.getString("location"),
                            rs.getInt("postalcode"),
                            rs.getBoolean("dresscode"),
                            rs.getBoolean("theme"),
                            rs.getString("description1"),
                            rs.getString("description2"),
                            rs.getInt("allowedage"),
                            rs.getBoolean("access")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return event;
    }
}