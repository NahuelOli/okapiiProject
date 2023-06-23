package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private BaseDeUsuarios users;
    private ArrayList<Desarrollador> desarrolladores;

    public Sistema() {
        users = new BaseDeUsuarios();
        desarrolladores = new ArrayList<>();
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
                    if (users.estaVacia()) {
                        System.out.println("No hay usuarios registrados.");
                        System.out.println("Volviendo al menu principal...");
                    } else {
                        try {
                            usuarioLocal = loguearUsuario();
                            usuarioLocal.verOpciones();
                        } catch (NullPointerException e) {
                            System.out.println("Usuario o password incorrecto puede ser pa.");
                        }
                    }
                    break;
                case "2":
                    registrarUsuarioAdmin();
                    break;
            }
        } while (!opcion.equalsIgnoreCase("0"));
    }

    public void mostrarOpciones() {
        System.out.println("1 - Loguear usuario.");
        System.out.println("2 - Registrarse como Administrador.");
        System.out.println("0 - Salir");
    }

    public Usuario loguearUsuario() {
        String user;
        String password;
        Usuario userABuscar = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un nombre de usuario: ");
        user = scan.nextLine();
        System.out.println("Ingrese una password: ");
        password = scan.nextLine();
        userABuscar = users.buscarUsuario(user);

        if (userABuscar != null) {
            if (userABuscar.sonIgualesPasswords(password)) {
                userABuscar.seLogueo();
                System.out.println("Iniciaste sesion con exito.");
            } else {
                userABuscar = null;
            }
        } else {
            System.out.println("No hay usuarios creados. Volviendo al menu de inicio.");
            arrancar();
        }
        return userABuscar;
    }

    private void registrarUsuarioAdmin() {
        String user;
        String password;
        String laClave = "1234";
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese la clave de Administrador: ");
        if (laClave.equals(scan.nextLine())) {
            System.out.println("Ingrese un nombre de usuario: ");
            user = scan.nextLine();
            System.out.println("Ingrese una password: ");
            password = scan.nextLine();

            if (users.chequearUsuario(user)) {
                users.crearUsuarioAdministrador(user, password);
            } else {
                System.out.println("Ese usuario ya existe!");
                System.out.println("Volviendo al menu principal...");
            }
        } else {
            System.out.println("La contrasena ingresada es incorrecta.");
            System.out.println("Volviendo al menu principal...");
        }
    }

}
