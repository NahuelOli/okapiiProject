package main;

import java.util.Scanner;

public class Sistema {

    private BaseDeUsuarios users;

    public Sistema() {
        users = new BaseDeUsuarios();
    }

    public void arrancar() {
        String opcion;
        Usuario usuarioLocal;
        do {
            Scanner scan = new Scanner(System.in);
            mostrarOpciones();
            opcion = scan.nextLine();
            while (opcion.equalsIgnoreCase("0") && opcion.equalsIgnoreCase("1") && opcion.equalsIgnoreCase("2")) {
                System.out.println("Opcion ingresada fuera de parametro.");
                mostrarOpciones();
                opcion = scan.nextLine();
            }
            System.out.println("Opcion: " + opcion);
            switch (opcion) {
                case "1":
                    usuarioLocal = loguearUsuario();
                    usuarioLocal.verOpciones();
                    break;
                case "2":
                    registrarUsuario();
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

    public Usuario loguearUsuario() {
        String user;
        String password;
        Usuario userABuscar = null;
        Scanner scan = new Scanner(System.in);
//        try
//        {
            if (!users.estaVacia()) 
            {
                System.out.println("Ingrese un nombre de usuario: ");
                user = scan.nextLine();
                userABuscar = users.buscarUsuario(user);
                if (userABuscar != null) 
                {
                    System.out.println("Ingrese una password: ");
                    password = scan.nextLine();
                    if (userABuscar.sonIgualesPasswords(password)) 
                    {
                        userABuscar.seLogueo();
                        System.out.println("Iniciaste sesion  con exito.");
                    } else 
                    {
                        System.out.println("Password incorrecto.");
                    }
                } else 
                {
                    System.out.println("Ese usuario no existe.");
                }
            }
            else
            {
                System.out.println("No hay usuarios creados. Volviendo al menu de inicio.");
            }
//        }
//        catch(NullPointerException e)
//        {
//            arrancar();
//            System.out.println("No hay usuarios creados. Volviendo al menu de inicio.");
//        }
//        finally
//        {
            return userABuscar;
//        }
    }

    public void registrarUsuario() {
        String user;
        String password;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un nombre de usuario: ");
        user = scan.nextLine();
        System.out.println("Ingrese una password: ");
        password = scan.nextLine();

        if (users.chequearUsuario(user)) {
            users.crearUsuario(user, password);
        } else {
            System.out.println("Ese usuario ya existe!");
            System.out.println("Volviendo al menu de inicio.");
        }
    }

}
