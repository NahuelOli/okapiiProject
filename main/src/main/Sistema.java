package main;

import java.util.Scanner;

public class Sistema {

    private BaseDeUsuarios users;

    public Sistema() {
        users = new BaseDeUsuarios();
    }

    public void arrancar() {
        String opcion;
        do {
            Scanner scan = new Scanner(System.in);
            mostrarOpciones();
            opcion = scan.nextLine();
            while  (opcion.equalsIgnoreCase("0") && opcion.equalsIgnoreCase("1") && opcion.equalsIgnoreCase("2")){
                System.out.println("Opcion ingresada fuera de parametro.");
                mostrarOpciones();
                opcion = scan.nextLine();
            }
            
            switch(opcion){
                case "1":
                    loguearUsuario();
                    break;
                case "2":
                    break;                    
            }
        } while (!opcion.equalsIgnoreCase("0"));
        System.out.println("fin");
    }

    public void mostrarOpciones() {
        System.out.println("1 - Loguear usuario.");
        System.out.println("2 - Crear usuario.");
        System.out.println("0 - Salir");
    }
    
    
    public void loguearUsuario(){
        String user;
        String password;
        Scanner scan = new Scanner (System.in);
        if(users.estaVacia()){
            System.out.println("No hay usuarios creados. Volviendo al menu de inicio.");
        }else{
            System.out.println("Ingrese un nombre de usuario: ");
            user = scan.nextLine();
            System.out.println("Ingrese una password: ");
            password = scan.nextLine();
        }
    }
    
}
