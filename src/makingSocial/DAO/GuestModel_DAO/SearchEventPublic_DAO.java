package makingSocial.DAO.GuestModel_DAO;

import makingSocial.controller.ConexionMySQL;
import makingSocial.controller.ConexionSingleton;
import makingSocial.model.EventModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SearchEventPublic_DAO {

    //imprime el string sobreescribiendo los lorem - btnSearch.addActionListener
    public static void overWriteLorem(EventModel newEvent) {
        String sql = "INSERT INTO Event (PostalCode) VALUES (?)";


        try {
            ConexionMySQL conexion = ConexionSingleton.getConexion();
            Connection con = conexion.getConnection();


            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, newEvent.getPostalCode());

                stmt.executeUpdate();

                //tiene que devolver el string modificando los lorem

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
    }

    // busca si hay eventos con ese codigo (se rellena por el form - lineas 59 a 64)- btnSearch.addActionListener (funcion en lineas 139 - 144)
    public void buscarEventosPorCodigoPostal(){
        String sql = "INSERT INTO Event (PostalCode) VALUES (?)";
    }
}