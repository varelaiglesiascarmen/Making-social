package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;
import makingSocial.model.GuestModel;
import makingSocial.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchEventPublic_DAO {


    //imprime el string sobreescribiendo los lorem - btnSearch.addActionListener


    // busca si hay eventos con ese codigo (se rellena por el form - lineas 59 a 64)- btnSearch.addActionListener (funcion en lineas 139 - 144)
    public static List<EventModel> buscarEventosPorCodigoPostal(EventModel newEvent) {
        List<EventModel> eventos = new ArrayList<>();

        String sql = "SELECT date, schedule, location, postalcode, dresscode, theme, description1, description2, allowedage, access FROM events WHERE postalcode = ? AND access = true";

        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, newEvent.getPostalCode());

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    EventModel event = new EventModel(
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("schedule").toLocalTime(),
                            rs.getString("location"),
                            rs.getInt("postalcode"),
                            rs.getBoolean("dresscode"),
                            rs.getBoolean("theme"),
                            rs.getString("description1"),
                            rs.getString("description2"),
                            rs.getInt("allowedage"),
                            rs.getBoolean("access")
                    );

                    eventos.add(event);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConexionSingleton.closeConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return eventos;
    }

    /*public int saveData(GuestModel newRegistrer, UserModel currentUser2) {
        int idGuest = searchID_Guest(currentUser2);

        String sql = "INSERT INTO Event (ID_User, NickName, Password, PassWordConfirm, E_Mail, Age, Name, civilStatus, RRSS, BIO, Attendance, ID_GuestModel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();


            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, newRegistrer.getID_User());
                stmt.setString(2, newRegistrer.getNickName());
                stmt.setString(3, newRegistrer.getPassword());
                stmt.setString(4, newRegistrer.getPassWordConfirm());
                stmt.setString(5, newRegistrer.getE_Mail());
                stmt.setInt(6, newRegistrer.getAge());
                stmt.setString(7, newRegistrer.getName());
                stmt.setString(8, newRegistrer.getCivilStatus());
                stmt.setString(9, newRegistrer.getRRSS());
                stmt.setString(10, newRegistrer.getBIO());
                stmt.setString(11, newRegistrer.getAttendance());
                stmt.setInt(12, idGuest);

                // lineas creadas por la bbdd
                int affectedRows = stmt.executeUpdate();

                if (affectedRows == 0) {
                    // fallo
                    return -1;
                }

                try (var generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // devuelve el id generado por la bdd
                        return generatedKeys.getInt(1);
                    } else {
                        return -1;
                    }
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
    }*/
}