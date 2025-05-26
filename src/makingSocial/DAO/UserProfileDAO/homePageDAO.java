package makingSocial.DAO.UserProfileDAO;

import makingSocial.controller.conexionMySQL;
import makingSocial.controller.conexionSingleton;
import makingSocial.model.userModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class homePageDAO {

    public boolean searchID_UserInHost(userModel currentUser) {
        String sql = "SELECT 1 FROM MakingSocial.HostModel WHERE ID_User = ?";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, currentUser.getID_User()); // Usamos el ID del usuario pasado como parámetro

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
                conexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean insertHostForUser(userModel user) {
        String sql = "INSERT INTO MakingSocial.HostModel (ID_User) VALUES (?)";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
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
                conexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean searchID_UserInGuest(userModel currentUser2) {
        String sql = "SELECT 1 FROM MakingSocial.GuestModel WHERE ID_User = ?";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, currentUser2.getID_User()); // Usamos el ID del usuario pasado como parámetro

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
                conexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean insertGuestForUser(userModel user) {
        String sql = "INSERT INTO MakingSocial.GuestModel (ID_User) VALUES (?)";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
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
                conexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}