package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SirLucho
 */
public class Gerente extends Usuario {

    private ArrayList<Cliente> clientes;
    private ArrayList<Desarrollador>  desarrolladores;

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
        int idNum;
        switch (opcion) {
            case "0":
                System.out.println("Cerrando sesion...");
                seDeslogueo();
                break;
            case "1":
                System.out.println("Cargando clientes...");
                String identificador;
                for (Usuario u : clientes) {
                    identificador = u.getIdentificador();
                    if (identificador.equalsIgnoreCase("cliente")) {
                        System.out.println("[" + u.getID() + "]  " + u.getUsername());
                    }
                }
                System.out.println("Ingrese un ID de cliente: ");
                opcion = scan.nextLine();
                for (Usuario u :clientes) {
                    identificador = u.getIdentificador();
                    if(idString.equalsIgnoreCase("-1")){
                        if (identificador.equalsIgnoreCase("cliente")) {
                            String num = Integer.toString(u.getID());
                            if(opcion.equalsIgnoreCase(num)){
                                idString = num;
                                idNum = Integer.parseInt(num);
                                System.out.println("ID encontrado, nombre del cliente: " + u.getUsername());
                                u.addProyecto();
                                break;
                            }
                        }
                    }
                }
                
                if(idString.equalsIgnoreCase("-1"))
                    System.out.println("El ID de cliente ingresado no existe.");
                    

                break;
        }
    }

    @Override
    public int getID() {
        return -1;
    }

    @Override
    public void addProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
