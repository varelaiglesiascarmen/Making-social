package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.UserModel;

import java.io.*;
import java.sql.*;

public class profileEditBIO_DAO {

    public int saveGuestModel(UserModel currentUser, String photoPath, String civilStatus, String rrss, String bio) {
        String sql = "INSERT INTO GuestModel (ID_User, Photo, CivilStatus, RRSS, BIO, Attendance) VALUES (?, ?, ?, ?, ?, ?)";
        FileInputStream inputStream = null;

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, currentUser.getID_User());

                if (photoPath != null && !photoPath.isEmpty()) {
                    File file = new File(photoPath);

                    if (file.exists() && file.isFile()) {
                        inputStream = new FileInputStream(file); // Abrimos sin try-with-resources

                        // Pasamos el InputStream y su longitud
                        stmt.setBinaryStream(2, inputStream, (int) file.length());
                    } else {
                        stmt.setNull(2, Types.BLOB);
                    }
                } else {
                    stmt.setNull(2, Types.BLOB);
                }

                stmt.setString(3, civilStatus);
                stmt.setString(4, rrss);
                stmt.setString(5, bio);
                stmt.setString(6, "");

                // Ejecutamos después de asegurar que el InputStream sigue abierto
                int affectedRows = stmt.executeUpdate();

                if (affectedRows == 0) return -1;

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    } else {
                        return -1;
                    }
                }

            } finally {
                // Cerramos el InputStream manualmente después de usarlo
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (SQLException | FileNotFoundException e) {
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

    public boolean insertIntoLogs(int guestModelID, int eventID) {
        String sql = "INSERT INTO Logs (ID_GuestModel, ID_Event) VALUES (?, ?)";
        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, guestModelID);
                stmt.setInt(2, eventID);
                int affected = stmt.executeUpdate();
                return affected > 0;
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
