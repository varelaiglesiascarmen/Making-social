package makingSocial.controller;

import makingSocial.model.UserModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignIn_Controller {
    public boolean ejecutarInsertDeleteUpdate(UserModel usuario) throws SQLException {
        if (ConexionSingleton.getConexion() != null) {
            try {
                String sql = "INSERT INTO UserProfile (nickname, password, email, age) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = ConexionSingleton.getConexion().prepareStatement(sql);
                stmt.setString(1, usuario.getNickName());
                stmt.setString(2, usuario.getPassword());
                stmt.setString(3, usuario.getE_Mail());
                stmt.setInt(4, usuario.getAge());
                stmt.executeUpdate();
                ConexionSingleton.closeConexion();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
