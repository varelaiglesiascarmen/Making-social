package makingSocial.controller;

import java.sql.*;
import java.util.Properties;
// import java.util.Calendar;
// import java.util.TimeZone;

/**
 * Clase para la conexión con una base de datos MySQL
 *
 * @author Francisco Jesús Delgado Almirón
 */
public class DBConnectionCopy {

    // AVISO: Credenciales en texto plano para realizar pruebas

    // DB si es MySQL, en Oracle base de datos remota se utiliza Wallets
    // Base de datos a la que nos conectamos
    // private String BD;

    // Usuario de la base de datos
    private String USUARIO = "ADMIN";

    // Contraseña del usuario de la base de datos
    private String PASS = "MakingS0cial;";

    // Objeto donde se almacenará nuestra conexión
    private Connection connection;

    // tnsAlias (Representa una conexión a una base de datos, estos pueden ser high, medium o low, dependiendo del tipo de conexión)
    // Puede cambiar entre _high, _medium o _low
    private String tnsAlias = "makingsocialdatabase_low";

    // Ruta de la Wallet
    private String walletPath;

    // Contraseña de la Wallet, necesaria para usarla, se crea a la hora de crearla en Oracle
    private String walletPassword = "Making5ser;";

    // Propiedades necesarias para realizar la conexión a la base de datos mediante Wallet
    private Properties props;

    // Solo funciona si vamos a conectar a una DB local
    // Indica que está en localhost
    // private String HOST;

    // Necesaria para la conexión con MySQL, con Oracle no es obligatoria
    // Zona horaria
    // private TimeZone zanahoraria;

    /**
     * Constructor de la clase
     *
     * @param usuario Usuario de la base de datos
     * @param pass Contraseña del usuario
     * @param tnsAlias Alias del TNS (ej. "adb_high")
     * @param walletPath Ruta a la carpeta del wallet
     * @param walletPassword Contraseña de la Wallet
     */
    public DBConnectionCopy(String usuario, String pass, String tnsAlias, String walletPath, String walletPassword) {
        this.USUARIO = usuario;
        this.PASS = pass;
        this.tnsAlias = tnsAlias; // ej. "adb_high"
        this.walletPath = walletPath; // ruta a la carpeta del wallet
        this.walletPassword = walletPassword; // contraseña de la wallet
        this.connection = null;

        // Usa una ruta relativa basada en la ubicación del proyecto
        String basePath = System.getProperty("user.dir"); // Obtiene la ruta del directorio raíz del proyecto
        walletPath = basePath + "/config/wallet"; // Concatenas la ruta relativa

        props = new Properties();
        props.setProperty("user", USUARIO);
        props.setProperty("password", PASS);
        props.setProperty("oracle.net.tns_admin", walletPath);
        props.setProperty("oracle.net.wallet_password", walletPassword); // Se agrega la contraseña de la Wallet
    }

    /**
     * Comprueba que el driver de MySQL esté correctamente integrado
     *
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    private void registrarDriver() throws SQLException {
        // Cambiado al driver de Oracle
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al conectar con Oracle: " + e.getMessage());
        }
    }

    /**
     * Conecta con la base de datos
     *
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    public void conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            registrarDriver();

            // Obtengo la zona horaria local
            // Calendar now = Calendar.getInstance();
            // zanahoraria = now.getTimeZone();

            // Para MySQL
            // connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BD + "?user="
            //        + USUARIO + "&password=" + PASS + "&useLegacyDatetimeCode=false&serverTimezone="
            //        + zanahoraria.getID());

            // Para Oracle
            connection = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@" + tnsAlias, props);
        }
    }

    /**
     * Cierra la conexión con la base de datos
     *
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    /**
     * Ejecuta una consulta SELECT
     *
     * @param consulta Consulta SELECT a ejecutar
     * @return Resultado de la consulta
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */

    public ResultSet ejecutarSelect(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rset = stmt.executeQuery(consulta);

        return rset;
    }

    /**
     * Ejecuta una consulta INSERT, DELETE o UPDATE
     *
     * @param consulta Consulta INSERT, DELETE o UPDATE a ejecutar
     * @return Cantidad de filas afectadas
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */

    public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        int fila = stmt.executeUpdate(consulta);

        return fila;
    }
}