package makingSocial.model;

import java.util.Scanner;

public class HostUser {

    // crear nuevo evento / create new event
    public void addEvent (Event x){

        // button
        System.out.println("Nuevo evento");
        Scanner scanner = new Scanner(System.in);

        //formulario
            // calendario choose
            System.out.println("¿Qué día es?");

            // reloj choose
            System.out.println("¿Ha qué hora es?");

            System.out.println("¿Dónde lo realizarás?");
            String location = scanner.nextLine();

            // opcion para marcar si hay o no dress code
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

            // opcion para marcar entre privado o publico
            // true = private event - false = public event
            System.out.println("¿Cómo es el acceso a éste?");

        // button
        System.out.println("Guardar evento");
    }
}
