package makingSocial.DAO.UserProfile_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomePage_DAO {

    public boolean searchID_UserInHost(UserModel x) {
        String sql = "SELECT 1 FROM MakingSocial.HostModel WHERE ID_User = ?";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, x.getID_User()); // Usamos el ID del usuario pasado como parámetro

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // El usuario existe
                        return true;
                    } else {
                        // El usuario no existe
                        return false;
                    }
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

    public boolean insertHostForUser(UserModel user) {
        String sql = "INSERT INTO MakingSocial.HostModel (ID_User) VALUES (?)";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, user.getID_User());
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