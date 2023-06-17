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

    public Cliente(String username, String password, int id) {
        super(username, password);
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

        } else {
            System.out.println("No tienes proyectos activos!");
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
}
