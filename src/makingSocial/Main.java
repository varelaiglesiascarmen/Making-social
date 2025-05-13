package makingSocial;

import makingSocial.controller.DBConnection;

import java.sql.SQLException;

public class Main {

    //explicacion antonio / prueba en codigo
    public void Main (String [] args){
        //crear un objeto de la clase DBConnection
        DBConnection connection = new DBConnection("ADMIN", "MakingS0cial;", "makingsocialdatabase_low", String walletPath, "Making5ser;");

        try{
            // conectar la bbdd
            connection.conectar("ADMIN", "MakingS0cial;", "makingsocialdatabase_low", String walletPath, "Making5ser;");
            // darle a ejecutar el programa para ver si funciona la conexion
            //hacer aquí todo el programa por defecto

            //insertar en la bbdd
            // construir String x
                                                                    // asi se guardaria el formulario
            String x = "INSERT INTO nombredelatabla (campos) VALUES ('"+nombredelboton.getText()+"',"+nombredelboton.getText()+")";
                                                        // por ej, si el campo es nombre y edad, se hace this.nombre,this.edad

            // en el parentesis hay que meter String x
            connection.ejecutarInsertDeleteUpdate(x);

            // desconectar la bbdd
            connection.desconectar();

        } catch (SQLException e){
            e.printStackTrace();
        }



    }


    // funciones del sistema / system functions
        // comprobar si el usuario está registrado o no / check whether the user is registered or not
        public void signinOrNot (){
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
