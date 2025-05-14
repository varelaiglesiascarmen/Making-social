package makingSocial.controller;

import makingSocial.model.User;

import java.sql.PreparedStatement;

public class SignIn_Controller {
    public boolean ejecutarInsertDeleteUpdate(User user) {
        ConexionMySQL conexion = new ConexionMySQL("root", "MakingS0cial", "MakingSocial");
        if (conexion != null) {
            try {
                String sql = "INSERT INTO UserProfile (nickname, password, email, age) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conexion.prepareStatement(sql);
                stmt.setString(1, user.getNickname());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getEmail());
                stmt.setInt(4, user.getAge());
                stmt.executeUpdate();
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
