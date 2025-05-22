package makingSocial.DAO.HostModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HostData_Extract_DAO {

    public int extract_ID(UserModel usuario) {
        String sql = "SELECT id_host FROM HostModel WHERE nickname = ?";

        int ID_Host = 0; // Valor por defecto si no se encuentra

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNickName());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {

                    ID_Host = (rs.getInt("id_host"));
                    return ID_Host;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de error más claro: valor negativo para indicar fallo
            return -1;
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return ID_Host;
    }
}