package makingSocial.controller;

import java.sql.SQLException;

/**
 * Clase Singleton para reutilizar una única instancia de conexión MySQL
 */
public class conexionSingleton {
    private static conexionMySQL instancia = null;

    private conexionSingleton() {
        // Constructor privado para que no se pueda instanciar desde fuera
    }

    /**
     * Devuelve una instancia única de la conexión
     */
    public static conexionMySQL getConexion() throws SQLException {
        if (instancia == null) {
            instancia = new conexionMySQL("root", "MakingS0cial", "MakingSocial");
            instancia.conectar(); // Conectar solo una vez
        }
        return instancia;
    }

    /**
     * Método para cerrar la conexión desde cualquier parte
     */
    public static void closeConexion() throws SQLException {
        if (instancia != null) {
            instancia.desconectar();
            instancia = null;
        }
    }
}
