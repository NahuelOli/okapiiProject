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
public class Gerente extends Usuario {
    
    private ArrayList<Usuario> clientes;
    public Gerente(String username, String password, ArrayList clientes) {
        super(username, password);
        this.clientes = clientes;
        
    }

    @Override
    public void verOpciones() {
        Scanner scan = new Scanner(System.in);
        String opcion;
        do {

            System.out.println("1 - Administrar clientes.");
            System.out.println("0 - Cerrar sesion.");
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
                System.out.println("Cargando clientes...");
                for (Usuario c:clientes) {
                    System.out.println("Nombre: "+c.getUsername());
                }
                break;
        }
    }

}
