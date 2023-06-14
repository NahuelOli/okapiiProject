/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author SirLucho
 */
public class Gerente extends Usuario {

    public Gerente(String username, String password) {
        super(username, password);
    }

    @Override
    public void verOpciones() {
        Scanner scan = new Scanner(System.in);
        String opcion;
        opcion = scan.nextLine();
        do {

            System.out.println("1 - Administrar clientes.");
            System.out.println("0 - Cerrar sesion.");
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
            case "1":
                System.out.println("Cargando clientes...");
                for (int i = 0; i < 10; i++) {

                }
                break;
        }
    }

}
