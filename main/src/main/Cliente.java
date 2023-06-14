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

    public Cliente(String username, String password) {
        super(username, password);
        proyectos = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void completarDatos() {
        while (nombre.isBlank()) {
            Scanner scan = new Scanner(System.in);
            String nombre;
            System.out.println("Por favor, completa con tu nombre de pila: ");
            nombre = scan.nextLine();
        }
    }

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
        } while ((!opcion.equalsIgnoreCase("0")));
        seDeslogueo();
    }

    public void hacerOpcion(String opcion) {
        switch (opcion) {
            case "0":
                System.out.println("Cerrando sesion...");
                break;
            case "1":
                verProyectos();
                break;
            case "2":
                super.cambiarPassword();
                break;
            case "3":
                verDatos();
                break;
            default:
                System.out.println("Opcion ingresada fuera de parametro.");
                break;
        }
    }

    private void verProyectos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void verDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
