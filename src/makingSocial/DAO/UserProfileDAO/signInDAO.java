package makingSocial.DAO.UserProfileDAO;

import makingSocial.controller.conexionMySQL;
import makingSocial.controller.conexionSingleton;
import makingSocial.model.userModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class signInDAO {
    public boolean createUser(userModel usuario) {
        String sql = "INSERT INTO UserProfile (nickname, password, name, age, e_mail) VALUES (?, ?, ?, ?, ?)";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNickName());
                stmt.setString(2, usuario.getPassword());
                stmt.setString(3, usuario.getName());
                stmt.setInt(4, usuario.getAge());
                stmt.setString(5, usuario.getE_Mail());

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