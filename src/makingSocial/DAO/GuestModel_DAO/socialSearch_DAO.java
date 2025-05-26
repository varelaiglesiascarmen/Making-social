package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.GuestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class socialSearch_DAO {
    public static List<GuestModel> getGuestsByEvent(int eventId) {
        List<GuestModel> guests = new ArrayList<>();
        String sql = "SELECT g.ID_GuestModel, u.ID_User, u.Name, u.Age, g.Photo, g.CivilStatus, g.RRSS, g.BIO " +
                "FROM Logs l " +
                "JOIN GuestModel g ON l.ID_GuestModel = g.ID_GuestModel " +
                "JOIN UserModel u ON g.ID_User = u.ID_User " +
                "WHERE l.ID_Event = ?";

        try (Connection con = ConexionSingleton.getConexion().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, eventId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                GuestModel guest = new GuestModel(
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
