/*package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEventWCode_DAO {
    public boolean ejecutarSelect(UserModel usuario) {
        String sql = "SELECT id_event FROM Event WHERE id_event = ?";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            // Falta crear una variable en Login
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, event.getID_Event());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }

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
*/