package makingSocial;

import makingSocial.controller.ConexionMySQL;

import java.sql.SQLException;

public class Main {

    //explicacion antonio / prueba en codigo
    public void Main (String [] args){
        //crear un objeto de la clase DBConnection
        ConexionMySQL conexion = new ConexionMySQL("root", "MakingS0cial", "MakingSocial");

        try {
            // Conectarse a la base de datos
            conexion.conectar();
            System.out.println("Conexión establecida correctamente.");

            // Cerrar la conexión
            conexion.desconectar();
            System.out.println("Conexión cerrada correctamente.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    // funciones del sistema / system functions
        // comprobar si el usuario está registrado o no / check whether the user is registered or not
    public void signinOrNot() {
        boolean registeredUser = true;

        if(registeredUser==true){
            // puede continuar
        }
        else{
            // tiene que llevarlo a signin
            registeredUser = false;
        }
    }

    // funciones comunes de usuario / usual functions
        // iniciar sesion / login

        // registrarse / sign in

        // cambiar roll / change roll

        // reportar problema / report

    // funciones anfitrion / host user functions
        // crear evento / create
            // addEvent de la clase HostUser

    // funciones invitado
        // introducir codigo id / introduce id code

        // buscar evento / search event

        // subir foto del día del evento / upload a photo of the day of the event

        // ver invitados 24hrs despues de la finalizacion del evento / show the guest 24hrs later finished event
            // filtrar busqueda en interesar o no
                // si es comun puede abrir chat
}
