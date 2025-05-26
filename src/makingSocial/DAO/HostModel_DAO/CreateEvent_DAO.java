package makingSocial.DAO.HostModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.UserModel;
import java.sql.*;


public class CreateEvent_DAO {

    public int searchID_Host(UserModel currentUser) {
        String sql = "SELECT ID_Host FROM MakingSocial.HostModel WHERE ID_User = ?";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, currentUser.getID_User());

                try (ResultSet rs = stmt.executeQuery()){
                    rs.next();
                    return rs.getInt("ID_Host");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int saveEvent(EventModel newEvent, UserModel currentUser) {
        int idHost = searchID_Host(currentUser);

        String sql = "INSERT INTO Event (date, schedule, location, PostalCode, dressCode, theme, description1, description2, allowedAge, access, id_host) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();


            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setObject(1, newEvent.getDate());
                stmt.setObject(2, newEvent.getSchedule());
                stmt.setString(3, newEvent.getLocation());
                stmt.setInt(4, newEvent.getPostalCode());
                stmt.setBoolean(5, newEvent.isDressCode());
                stmt.setBoolean(6, newEvent.isTheme());
                // dressCode
                stmt.setString(7, newEvent.getDescription1());
                // Theme
                stmt.setString(8, newEvent.getDescription2());
                stmt.setInt(9, newEvent.getAllowedAge());
                stmt.setBoolean(10, newEvent.isAccess());
                stmt.setInt(11, idHost);

                // lineas creadas por la bbdd
                int affectedRows = stmt.executeUpdate();

                if (affectedRows == 0) {
                    // fallo
                    return -1;
                }

                try (var generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // devuelve el id generado por la bdd
                        return generatedKeys.getInt(1);
                    } else {
                        return -1;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}