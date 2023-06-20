package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    private ArrayList<Usuario> usuarios;

    public Administrador(String username, String password, ArrayList usuarios) {
        super(username, password);
        this.usuarios = usuarios;
    }

    public void verOpciones() {
        {
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

    }

}
