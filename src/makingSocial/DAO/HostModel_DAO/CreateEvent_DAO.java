package makingSocial.DAO.HostModel_DAO;


import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateEvent_DAO {
    public boolean ejecutarInsertDeleteUpdate(EventModel newEvent) {
        String sql = "INSERT INTO Event (date, schedule, location, PostalCode, dressCode, theme, description1_dresscode, description2_theme, allowedAge, access) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();


            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setObject(1, newEvent.getDate());
                stmt.setObject(2, newEvent.getSchedule());
                stmt.setString(3, newEvent.getLocation());
                stmt.setInt(4, newEvent.getPostalCode());
                stmt.setBoolean(5, newEvent.isDressCode());
                stmt.setBoolean(6, newEvent.isTheme());
                stmt.setString(7, newEvent.getDescription1());
                stmt.setString(8, newEvent.getDescription2());
                stmt.setInt(9, newEvent.getAllowedAge());
                stmt.setBoolean(10, newEvent.isAccess());


                stmt.executeUpdate();


                return true;


            }


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}


