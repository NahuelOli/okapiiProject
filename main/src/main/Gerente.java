package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SirLucho
 */
public class Gerente extends Usuario implements Serializable {

    private ArrayList<Usuario> clientes;

    public Gerente(String username, String password, String identificador, ArrayList clientes) {
        super(username, password, identificador);
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
        Scanner scan = new Scanner(System.in);
        String idString = "-1";
        switch (opcion) {
            case "0":
                System.out.println("Cerrando sesion...");
                seDeslogueo();
                break;
            case "1":
                System.out.println("Cargando clientes...");
                for (Usuario u : clientes) {
                    if (u instanceof Cliente) {
                        Cliente cliente = (Cliente) u;
                        System.out.println("[" + cliente.getID() + "]  " + cliente.getUsername());
                    }
                }
                System.out.println("Ingrese un ID de cliente: ");
                opcion = scan.nextLine();
                for (Usuario u : clientes) {
                    if (idString.equalsIgnoreCase("-1")) {
                        if (u instanceof Cliente) {
                            Cliente cliente = (Cliente) u;
                            String num = Integer.toString(cliente.getID());
                            if (opcion.equalsIgnoreCase(num)) {
                                idString = num;
                                System.out.println("ID encontrado, nombre del cliente: " + cliente.getUsername());
                                cliente.addProyecto();
                            }
                        }
                    }
                }
                if (idString.equalsIgnoreCase("-1")) {
                    System.out.println("El ID de cliente ingresado no existe.");
                }
                break;
        }
    }
}
