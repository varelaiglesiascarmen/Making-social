package makingSocial.DAO.GuestModelDAO;

import makingSocial.controller.conexionMySQL;
import makingSocial.controller.conexionSingleton;
import makingSocial.model.eventModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchEventPublicDAO {

    public static List<eventModel> searchPublicEvent(int postalCode) {
        List<eventModel> eventList = new ArrayList<>();

        String sql = "SELECT id_event, id_host, date, schedule, location, postalcode, dresscode, theme, description1, description2, allowedage, access FROM Event WHERE postalcode = ? AND access = true";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, postalCode);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    eventModel event = new eventModel(
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

                    eventList.add(event);
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

        return eventList;
    }


}