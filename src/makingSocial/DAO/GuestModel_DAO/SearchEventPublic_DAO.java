package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.GuestModel;
import makingSocial.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchEventPublic_DAO {

    public static List<EventModel> searchPublicEvent(int postalCode) {
        List<EventModel> eventList = new ArrayList<>();

        String sql = "SELECT date, schedule, location, postalcode, dresscode, theme, description1, description2, allowedage, access FROM event WHERE postalcode = ? AND access = true";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, postalCode);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    EventModel event = new EventModel(
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

                    eventList.add(event);
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

        return eventList;
    }
}