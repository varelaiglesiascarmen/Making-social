package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.GuestModel;
import makingSocial.model.UserModel;

import java.sql.*;

public class SearchEvent_DAO {
    public int searchID_Host(UserModel currentUser2) {
        String sql = "SELECT ID_Guest FROM MakingSocial.GuestModel WHERE ID_User = ?";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, currentUser2.getID_User());

                try (ResultSet rs = stmt.executeQuery()){
                    rs.next();
                    return rs.getInt("ID_Guest");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
