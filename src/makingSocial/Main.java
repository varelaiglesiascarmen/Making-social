package makingSocial;

public class Main {

    // funciones del sistema / system functions
        // registrar nuevo usuario / sign in new user
            // version 2.0 - puedes registrarte mediante google, icloud, facebook / version 2.0 - you can sign in with google, icloud or facebook
        // iniciar sesion / login

        // comprobar si el usuario está registrado o no / check whether the user is registered or not

        // conexión bbdd / conection ddbb
        public void insertEvent(String event_ID, int date, int schedule, String location, String dressCode, int allowedAge, String themed, boolean access, String host_ID){
            String sql = "INSERT INTO EVENTS (EVENT_ID, DATA, SCHEDULE, LOCATION, ALLOWED_AGE, THEMED, ACCESS, HOST_ID) VALUES (?, ?, ?)";

            // Le falta acceso a los datos


        }

    // funciones comunes de usuario / usual functions
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
