package makingSocial.controller;

import makingSocial.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignIn_Controller {
    public boolean ejecutarInsertDeleteUpdate(User user) {
        ConexionMySQL conexion = new ConexionMySQL("root", "MakingS0cial", "MakingSocial");
        if (conexion != null) {
            try {
                String sql = "INSERT INTO UserProfile (nickname, password, email, age) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conexion.prepareStatement(sql);
                stmt.setString(1, user.getNickName());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getE_Mail());
                stmt.setInt(4, user.getAge());
                stmt.executeUpdate();
                conexion.desconectar();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
