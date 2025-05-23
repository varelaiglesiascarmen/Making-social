package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class attendedEvents_DAO {
    /*
    public class obtenerEventosAsistidosPorUsuario(int ID_Event){

    }*/
    /*public static UserModel getCurrentUser(UserModel currentUser) {
        String sql = "SELECT ID_Event, date, schedule, location, PostalCode, dressCode, theme, description1, description2, allowedAge, access, ID_Host FROM Event WHERE id_event = ? AND id_guestmodel = ?";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, newLog.getID_Event());
                stmt.setString(2, newLog.getID_GuestModel());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    EventModel newEvent = new EventModel(
                            rs.getInt("id_event"),
                            rs.getDate("date"),
                            rs.getDate("schedule"),
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
                    return newEvent;
                } else {
                    return null; // no se encontró usuario
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }*/

}
