package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    private ArrayList<Usuario> usuarios;

    public Administrador(String username, String password, ArrayList usuarios, String identificador) {
        super(username, password, identificador);
        this.usuarios = usuarios;
    }

    public void verOpciones() {
        {
            Scanner scan = new Scanner(System.in);
            String opcion;
            do {

                System.out.println("1 - Registrar cliente.");
                System.out.println("2 - Registrar gerente.");
                System.out.println("3 - Registrar desarrollador.");
                System.out.println("4 - .");
                System.out.println("0 - Cerrar sesion.");
                System.out.println("Elige una opcion: ");

                opcion = scan.nextLine();
                hacerOpcion(opcion);
            } while (( estaLogueado() ));
        }
    }
    
    public void hacerOpcion(String opcion){
        switch (opcion){
            case "0":
                super.seDeslogueo();
                break;
            case "1":
                break;
        }
    }

    @Override
    public int getID() {
        return -1;
    }

}
