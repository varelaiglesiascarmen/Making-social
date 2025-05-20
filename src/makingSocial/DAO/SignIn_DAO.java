package makingSocial.DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignIn_DAO {
    public boolean ejecutarInsertDeleteUpdate(UserModel usuario) {
        String sql = "INSERT INTO UserProfile (NickName, Password, PasswordConfirm, E_Mail, Age, Name) VALUES (?, ?, ?, ?)";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNickName());
                stmt.setString(2, usuario.getPassword());
                stmt.setString(3, usuario.getE_Mail());
                stmt.setInt(4, usuario.getAge());

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