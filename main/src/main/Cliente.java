/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SirLucho
 */
public class Cliente extends Usuario {

    private int id;
    private String nombre;
    private ArrayList<Proyecto> proyectos;
    private String correoElectronico;
    private String numTelefono;

    public Cliente(String username, String password, int id, String identificador) {
        super(username, password, identificador);
        this.id = id;
        proyectos = new ArrayList<>();
        nombre = "";
        correoElectronico = "";
        numTelefono = "";

    }

    public void setId(int id) {
        this.id = id;
    }

    public void completarDatos() {
        Scanner scan = new Scanner(System.in);
        while (nombre.isBlank()) {
            System.out.println("Por favor, completa con tu nombre de pila: ");
            nombre = scan.nextLine();
        }
        while (correoElectronico.isBlank()) {
            System.out.println("Correo electronico: ");
            correoElectronico = scan.nextLine();
        }
        while (numTelefono.isBlank()) {
            System.out.println("Numero de telefono: ");
            numTelefono = scan.nextLine();
        }
    }

    @Override
    public void verOpciones() {
        Scanner scan = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("1 - Ver proyectos");
            //System.out.println("2 - Agregar proyecto");
            System.out.println("2 - Cambiar password");
            System.out.println("3 - Ver mis datos");
            System.out.println("0 - Cerrar sesion");
            System.out.println("Elige una opcion: ");

            opcion = scan.nextLine();
            hacerOpcion(opcion);
        } while ((estaLogueado()));
    }

    public void hacerOpcion(String opcion) {
        switch (opcion) {
            case "0":
                System.out.println("Cerrando sesion...");
                seDeslogueo();
                break;
            case "1":
                verProyectos();
                break;
            //case "2":
            //    addProyecto();
            //    break;
            case "2":
                super.cambiarPassword();
                break;
            case "3":
                if (!datosCompletos()) {
                    verDatos();
                } else {
                    verDatosCompletos();
                }
                break;
            default:
                System.out.println("Opcion ingresada fuera de parametro.");
                break;
        }
    }

    private void verProyectos() {
        if (!proyectos.isEmpty()) {
            for (Proyecto p : proyectos) {
                System.out.println("Titulo: " + p.getNombre());
                System.out.println("Fecha de inicio: " + p.getFecha());
                System.out.println("Descripcion: " + p.getDescripcion());
                System.out.println("Presupuesto: " + p.getPresupuesto());
                System.out.println("");
                if (p.tieneDesarrolladores()) {
                    p.mostrarDesarrolladores();
                } else {
                    System.out.println("El proyecto no tiene desarrolladores asignados.");
                }

                if (p.getEstado() == false) {
                    System.out.println("Estado: " + p.estaSinFinalizar());
                } else {
                    System.out.println("Estado: " + p.estaFinalizado());
                }
            }
        } else {
            System.out.println("No tienes proyectos!");
        }
    }

    private void verDatos() {
        Scanner scan = new Scanner(System.in);
        String opcion = "";
        while (!opcion.equals("0") && !opcion.equals("1")) {
            System.out.println("ID: " + id);
            System.out.println("Proyectos activos: " + proyectos.size());

            System.out.println("");
            System.out.println("0 - Salir");
            System.out.println("1 - Completar datos");

            opcion = scan.nextLine();
        }
        if (opcion.equals("1")) {
            completarDatos();
        }
    }

    private void verDatosCompletos() {
        Scanner scan = new Scanner(System.in);
        String opcion = "";
        while (!opcion.equals("0")) {
            System.out.println("ID: " + id);
            System.out.println("Proyectos activos: " + proyectos.size());
            System.out.println("Nombre: " + nombre);
            System.out.println("Correo electronico: " + correoElectronico);
            System.out.println("Numero de telefono: " + numTelefono);
            System.out.println("");
            System.out.println("0 - Salir");
            opcion = scan.nextLine();
        }
    }

    private boolean datosCompletos() {
        return (!nombre.isBlank() && !numTelefono.isBlank() && !correoElectronico.isBlank());
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void addProyecto() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese a continuacion el titulo de su proyecto: ");
        String titulo = scan.nextLine();
        System.out.println("Ingrese a continuacion la descripcion de su proyecto: ");
        String descripcion = scan.nextLine();
        System.out.println("Ingrese a continuacion el presupuesto estimado para su proyecto: ");
        String presupuesto = scan.nextLine();
        Proyecto proyecto = new Proyecto(titulo, descripcion, presupuesto);
        proyectos.add(proyecto);

    }

}
