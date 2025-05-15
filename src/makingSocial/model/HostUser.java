package makingSocial.model;

import makingSocial.controller.ConexionMySQL;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HostUser {

    // attributes
    private String hostUser_ID;
    private String name;
    private String lastName;

    // constructor / constructor
    public HostUser(String userName, String password, String mail, boolean userType, String hostUser_ID, String name, String lastName) {
        //super(userName, password, mail, userType);
        this.hostUser_ID = hostUser_ID;
        this.name = name;
        this.lastName = lastName;
    }

    //getters & setters
    public String getHostUser_ID() {
        return hostUser_ID;
    }

    public void setHostUser_ID(String newHostUser_ID) {
        this.hostUser_ID = newHostUser_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    // toString
    @Override
    public String toString() {
        return "HostUser{" +
                "hostUser_ID='" + hostUser_ID + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    // metodos / method
    public void addEvent (Event x){

    // Crear nuevo evento / create new event
        // botón para abrir formulario / button to open form
        System.out.println("Nuevo evento");
        Scanner scanner = new Scanner(System.in);

        /* formulario , si el usuario no ha rellenado todos los campos no puede guardar el evento en el
        ultimo botón / form, if the user has not filled out all the fields, he cannot save the event on the last button */
            // abrir calendario para escoger fecha / open calendar to save the date
            System.out.println("¿Qué día es?");

            // abrir reloj para escoger horario / open clock to save schedule
            System.out.println("¿Ha qué hora es?");

            System.out.println("¿Dónde lo realizarás?");
            String location = scanner.nextLine();

            // marcar si hay o no dress code / choose if there is or not dress code
            System.out.println("¿Hay dress code?");
            boolean dressCode = false;
                if (dressCode == true){
                    String dressCodeTrue = scanner.nextLine();
                    dressCode = true;
                }

            System.out.println("Edad permitada del evento:");

                try {
                String allowedAgeEntrada = scanner.nextLine();
                int allowedAge = Integer.parseInt(allowedAgeEntrada);

                if (allowedAge >= 0 && allowedAge <= 99) {
                    System.out.println("Edad guardada: " + allowedAge);
                } else {
                    System.out.println("Inserte edad válida");
                }
                } catch (NumberFormatException e) {
                System.out.println("Inserte edad válida");
                }

            System.out.println("¿Hay alguna temática en particular?");
            boolean themed = false;
            if (themed == true){
                String dressCodeTrue = scanner.nextLine();
                themed = true;
            }

            // marcar privado o publico / choose private or public
            // true = private event - false = public event
            System.out.println("¿Cómo es el acceso a éste?");

        // botón para guardar el evento / button to save event
        System.out.println("Guardar evento");

    // Generar codigo id evento / generate id code from event

        Random id_generate = new Random();
        String event_ID = UUID.randomUUID().toString();

        /* UUID.randomUUID() → Genera un nuevo UUID aleatorio.
           .toString() → Convierte ese UUID en una cadena legible (String), para que puedas guardarla o imprimirla.
           String event_ID = ... → Guarda esa cadena en una variable llamada event_ID. */

    }

    //public abstract void changeRoll(){
       // return ;
  //  }

}