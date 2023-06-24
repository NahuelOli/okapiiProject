package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario implements Serializable {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Desarrollador> devs;

    public Administrador(String username, String password, ArrayList usuarios, ArrayList devs, String identificador) {
        super(username, password, identificador);
        this.usuarios = usuarios;
        this.devs = devs;
    }

    public void verOpciones() {
        {
            Scanner scan = new Scanner(System.in);
            String opcion;
            do {

                System.out.println("\n1 - Registrar cliente.");
                System.out.println("2 - Registrar gerente.");
                System.out.println("3 - Registrar desarrollador.");
                System.out.println("4 - Ver desarrolladores disponibles.");
                System.out.println("5 - Asignar desarrolladores.");
                System.out.println("6 - Ver todos los usuarios.");
                System.out.println("0 - Cerrar sesion.");
                System.out.println("Elige una opcion: ");

                opcion = scan.nextLine();
                hacerOpcion(opcion);
            } while ((estaLogueado()));
        }
    }

    public void hacerOpcion(String opcion) {
        switch (opcion) {
            case "0":
                super.seDeslogueo();
                break;
            case "1":
                registrarUsuarioCliente();
                break;
            case "2":
                registrarUsuarioGerente();
                break;
            case "3":
                registrarUsuarioDesarrollador();
                break;
            case "4":
                if (hayDesarrolladoresDisponibles()) {
                    mostrarDesarrolladoresDisponibles();
                } else {
                    System.out.println("No hay desarrolladores disponibles.");
                }
                break;
            case "5":
                asignarDesarrolladores();
                break;
            case "6":
                verUsuarios();
                break;
        }
    }

    private void verUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println("\n=========================");
            System.out.println("\nNombre: " + u.getUsername());
            System.out.println("Clave: " + u.getPassword());
            System.out.println("Tipo: " + u.getIdentificador());

        }
    }

    public boolean chequearUsuario(String user) {
        boolean estaDisponible = true;
        Usuario userAComparar;
        if (!usuarios.isEmpty()) {
            int i = 0;
            do {
                userAComparar = usuarios.get(i);
                i++;
            } while (i < usuarios.size() && !userAComparar.sonIgualesUsers(user));

            if (userAComparar.sonIgualesUsers(user)) {
                estaDisponible = false;
            }

        }
        return estaDisponible;
    }

    public Usuario buscarUsuario(String username) {
        Usuario userBuscado = null;
        int i = 0;
        if (!usuarios.isEmpty()) {
            do {
                userBuscado = usuarios.get(i);
                i++;
            } while (i < usuarios.size() && !userBuscado.sonIgualesUsers(username));

            if (!(i < usuarios.size()) && !userBuscado.sonIgualesUsers(username)) {
                userBuscado = null;
            }
        }

        return userBuscado;
    }

    public void crearUsuarioCliente(String user, String password) {
        Cliente usuarioEntrante = new Cliente(user, password, usuarios.size() + 1, "cliente");
        if (usuarios.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }

    public void crearUsuarioGerente(String user, String password) {
        Gerente usuarioEntrante = new Gerente(user, password, "gerente", usuarios);
        if (usuarios.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }

    public void registrarUsuarioCliente() {
        String user;
        String password;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nIngrese un nombre de usuario: ");
        user = scan.nextLine();
        System.out.println("Ingrese una clave: ");
        password = scan.nextLine();

        if (chequearUsuario(user)) {
            crearUsuarioCliente(user, password);
        } else {
            System.out.println("Ese usuario ya existe!");
        }
    }

    private void registrarUsuarioGerente() {
        String user;
        String password;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nIngrese un nombre de usuario: ");
        user = scan.nextLine();
        System.out.println("Ingrese una clave: ");
        password = scan.nextLine();

        if (chequearUsuario(user)) {
            crearUsuarioGerente(user, password);
        } else {
            System.out.println("Ese usuario ya existe!");
            System.out.println("Volviendo al menu principal...");
        }
    }

    private void registrarUsuarioDesarrollador() {
        String user;
        String habilidad = "";
        ArrayList<String> habilidades = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el nombre del desarrollador: ");
        user = scan.nextLine();

        if (chequearUsuario(user)) {
            while (!habilidad.equalsIgnoreCase("0")) {
                System.out.println("Ingrese una habilidad del desarrollador (Escriba '0' para detener el ingreso de habilidades)");
                habilidad = scan.nextLine();
                if (!habilidad.equalsIgnoreCase("0")) {
                    habilidades.add(habilidad);
                }
            }
            crearUsuarioDesarrollador(user, habilidades);
        } else {
            System.out.println("Ese desarrollador ya existe!");
        }
    }

    private void crearUsuarioDesarrollador(String user, ArrayList<String> habilidades) {
        Desarrollador dev = new Desarrollador(user, habilidades);
        if (devs.add(dev)) {
            System.out.println("Usuario creado con exito.");
        }
    }

    public void mostrarDesarrolladoresDisponibles() {
        for (Desarrollador dev : devs) {
            if (dev.getEstaDisponible()) {
                System.out.println("ID [" + devs.indexOf(dev) + "]   " + dev.getNombre());
            }
        }
    }

    public boolean hayDesarrolladoresDisponibles() {
        boolean flag = false;
        int i = 0;
        Desarrollador dev;
        do {
            dev = devs.get(i);
            i++;
        } while (!dev.getEstaDisponible() && i < devs.size());

        if (dev.getEstaDisponible()) {
            flag = true;
        }
        return flag;
    }

    private void asignarDesarrolladores() {
        if (hayDesarrolladoresDisponibles()) {

            int numProyecto, numDev;
            String opcion;
            Desarrollador dev;

            Scanner scan = new Scanner(System.in);
            for (Usuario u : usuarios) {
                if (u instanceof Cliente) {
                    Cliente cliente = (Cliente) u;
                    System.out.println("Cliente: " + cliente.getUsername());

                    if (cliente.tieneProyectos()) {
                        try {
                            cliente.verTituloProyecto();
                            System.out.println("Seleccione el proyecto al que quiere asignar un desarrollador ");
                            opcion = scan.nextLine();
                            numProyecto = Integer.parseInt(opcion);
                            mostrarDesarrolladoresDisponibles();
                            System.out.println("Ingrese el ID del desarrollador a asignar: ");
                            opcion = scan.nextLine();
                            numDev = Integer.parseInt(opcion);
                            dev = devs.get(numDev);
                            cliente.setDesarrollador(numProyecto, dev);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Ingresaste un ID fuera de parametro.");
                        }
                    } else {
                        System.out.println("El cliente no tiene proyectos.");
                    }
                }
            }
        } else {
            System.out.println("No hay desarrolladores disponibles!");
        }

    }

}
