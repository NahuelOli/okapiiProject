package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SirLucho
 */
public class Gerente extends Usuario {
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
        switch (opcion) {
            case "0":
                System.out.println("Cerrando sesion...");
                seDeslogueo();
                break;
            case "1":
                System.out.println("Cargando clientes...");
                String identificador;
                for (Usuario u : clientes) {
                    identificador  = u.getIdentificador();
                    if(identificador.equalsIgnoreCase("cliente")){
                        System.out.println("ID: " + u.getID() + " Username: "+ u.getUsername());
                    }
                }
                break;
        }
    }

    @Override
    public int getID() {
        return -1;
    }

}
