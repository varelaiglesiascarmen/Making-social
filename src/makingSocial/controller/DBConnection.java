package makingSocial.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Compartir data la bbdd / share data at our ddbb
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";  // SID = no se sabe todavia
        String user = "ADMIN";
        String password = "MakingS0cial;";

        return DriverManager.getConnection(url, user, password);
    }
}
