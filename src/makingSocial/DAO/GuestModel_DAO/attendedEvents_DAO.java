package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class attendedEvents_DAO {

    public static List<EventModel> obtenerEventosAsistidosPorUsuario(int userID_User) {
        List<EventModel> eventos = new ArrayList<>();

        String sql = "SELECT e.ID_Event, e.date, e.schedule, e.location, e.PostalCode, " +
                "e.dressCode, e.theme, e.description1, e.description2, e.allowedAge, e.access, e.ID_Host " +
                "FROM Logs l " +
                "JOIN GuestModel g ON l.ID_GuestModel = g.ID_GuestModel " +
                "JOIN Event e ON l.ID_Event = e.ID_Event " +
                "WHERE g.ID_User = ?";

        try {
            Connection con = ConexionSingleton.getConexion().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userID_User); // Ahora filtramos por ID_User

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EventModel evento = new EventModel(
                        rs.getInt("ID_Event"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("schedule").toLocalTime(),
                        rs.getString("location"),
                        rs.getInt("PostalCode"),
                        rs.getBoolean("dressCode"),
                        rs.getBoolean("theme"),
                        rs.getString("description1"),
                        rs.getString("description2"),
                        rs.getInt("allowedAge"),
                        rs.getBoolean("access"),
                        rs.getInt("ID_Host")
                );
                eventos.add(evento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }
}
