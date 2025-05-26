package makingSocial.DAO.GuestModelDAO;

import makingSocial.controller.conexionSingleton;
import makingSocial.model.guestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class socialSearchDAO {
    public static List<guestModel> getGuestsByEvent(int eventId) {
        List<guestModel> guests = new ArrayList<>();
        String sql = "SELECT g.ID_GuestModel, u.ID_User, u.Name, u.Age, g.Photo, g.CivilStatus, g.RRSS, g.BIO " +
                "FROM Logs l " +
                "JOIN GuestModel g ON l.ID_GuestModel = g.ID_GuestModel " +
                "JOIN UserModel u ON g.ID_User = u.ID_User " +
                "WHERE l.ID_Event = ?";

        try (Connection con = conexionSingleton.getConexion().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, eventId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                guestModel guest = new guestModel(
                        rs.getInt("ID_User"),
                        rs.getInt("Age"),
                        rs.getString("Name"),
                        rs.getBytes("Photo"),
                        rs.getString("CivilStatus"),
                        rs.getString("RRSS"),
                        rs.getString("BIO"),
                        null,
                        rs.getInt("ID_GuestModel")
                );
                guests.add(guest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guests;
    }
}
