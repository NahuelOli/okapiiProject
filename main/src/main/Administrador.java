package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Desarrollador> devs;
    private Administrador admin;

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

                System.out.println("1 - Registrar cliente.");
                System.out.println("2 - Registrar gerente.");
                System.out.println("3 - Registrar desarrollador.");
                System.out.println("4 - Ver desarrolladores.");
                System.out.println("5 - Asignar desarrolladores.");
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
                mostrarDesarrolladoresDisponibles();
                break;
            case "5":
                asignarDesarrolladores();
                break;
        }
    }

    @Override
    public int getID() {
        return -1;
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
        //idSetter++;
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

        System.out.println("Ingrese un nombre de usuario: ");
        user = scan.nextLine();
        System.out.println("Ingrese una password: ");
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
        //String laClave = "Gerent3$";
        Scanner scan = new Scanner(System.in);

        //System.out.println("Ingrese la contrasena de Gerente: ");
        //if (laClave.equals(scan.nextLine())) {
        System.out.println("Ingrese un nombre de usuario: ");
        user = scan.nextLine();
        System.out.println("Ingrese una password: ");
        password = scan.nextLine();

        if (chequearUsuario(user)) {
            crearUsuarioGerente(user, password);
        } else {
            System.out.println("Ese usuario ya existe!");
            System.out.println("Volviendo al menu principal...");
        }
        //} else {
        //System.out.println("La contrasena ingresada es incorrecta.");
        //System.out.println("Volviendo al menu principal...");
        //}
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
            System.out.println("Ese username ya esta en uso!");
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
                System.out.println("ID " + devs.indexOf(dev) + "  Desarrollador: " + dev.getNombre() + " esta disponible.");
            }
        }
    }

    private void asignarDesarrolladores() {
        String identificador;
        int numProyecto, numDev;
        String opcion;
        Desarrollador dev;

        Scanner scan = new Scanner(System.in);
        for (Usuario u : usuarios) {
            if(u instanceof Cliente){
                Cliente cliente = (Cliente) u;
                System.out.println("Cliente: " + cliente.getUsername());
                if(cliente.tieneProyectos()){
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
                }else{
                    System.out.println("No tiene proyectos.");
                }
            }
            /*identificador = u.getIdentificador();
            if (identificador.equalsIgnoreCase("cliente") && u.tieneProyectos()) {
                System.out.println("Cliente: " + u.getUsername());
                u.verTituloProyecto(admin, devs);
                System.out.println("Desea asignar desarrolladores? [1]SI [2]NO");
                opcion = scan.nextLine();
                while (!opcion.equalsIgnoreCase("1") || !opcion.equalsIgnoreCase("2")) {
                    System.out.println("La opcion ingresada no es valida, intentelo de nuevo a continuacion: ");
                    opcion = scan.nextLine();
                }
                if (opcion.equalsIgnoreCase("1")) {
                    mostrarDesarrolladoresDisponibles();
                    System.out.println("Ingrese el ID del desarrollador a asignar: ");
                    opcion = scan.nextLine();
                    num = Integer.parseInt(opcion);
                    u.setDesarrollador(devs.get(num));
                } else {
                    System.out.println("no joya pa");
                }
            }*/
        }
    }

    @Override
    public void addProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean tieneProyectos() {
        return false;
    }

    /*@Override
    public void setDesarrollador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }*/

}
