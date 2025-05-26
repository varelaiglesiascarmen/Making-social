package makingSocial.DAO.UserProfileDAO;

import makingSocial.controller.conexionMySQL;
import makingSocial.controller.conexionSingleton;
import makingSocial.model.userModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {

    public static userModel getCurrentUser(userModel currentUser) {
        String sql = "SELECT nickname, id_user, e_mail, age, name FROM UserProfile WHERE nickname = ? AND password = ?";

        try {
            conexionMySQL conexion = conexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, currentUser.getNickName());
                stmt.setString(2, currentUser.getPassword());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    userModel user = new userModel(
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
                conexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
