package makingSocial.DAO.UserProfile_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_DAO {
    public boolean ejecutarSelect(UserModel usuario) {
        String sql = "SELECT nickname, password, id_user, e_mail, age, name FROM UserProfile WHERE nickname = ? AND password = ?";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            // Falta crear una variable en Login
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNickName());
                stmt.setString(2, usuario.getPassword());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return true; // usuario y contraseña encontrados
                } else {
                    return false; // no coincide
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

    public static UserModel getCurrentUser(UserModel currentUser) {
        String sql = "SELECT nickname, id_user, e_mail, age, name FROM UserProfile WHERE nickname = ? AND password = ?";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, currentUser.getNickName());
                stmt.setString(2, currentUser.getPassword());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    UserModel user = new UserModel(
                            rs.getInt("id_user"),
                            rs.getString("nickname"),
                           null,
                            null,
                            rs.getString("e_mail"),
                            rs.getInt("age"),
                            rs.getString("name")
                    );
                    return user;
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
    }


}
