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
                    // Aquí llena todos los datos restantes en el objeto usuario creado al realizar login, Java añade los datos restantes, solo si hay un constructor con todos estos datos
                    usuario.setID_User(rs.getInt("id_user"));
                    usuario.setE_Mail(rs.getString("e_mail"));
                    usuario.setAge(rs.getInt("age"));
                    usuario.setName(rs.getString("name"));
                    // nickname y password ya están
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
}
