package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Desarrollador extends Usuario {

    private ArrayList<String> habilidades;
    private boolean estaDisponible;

    public Desarrollador(String nombre, String password, ArrayList habilidades) {
        super(nombre, password, "Desarrollador");
        this.habilidades = habilidades;
        estaDisponible = true;
        
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }
    
    public String getNombre() {
        return super.getUsername();
    }

    void mostrarInformacion() {
        System.out.println("Nombre: " + super.getUsername());
        for (String skills : habilidades) {
            System.out.println(skills);
        }
    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void verOpciones() {
        Scanner scan = new Scanner(System.in);
        String opcion;
        do {

            System.out.println("1 - Ver mis habilidades.");
            System.out.println("2 - Ver mis proyectos.");
            System.out.println("0 - Cerrar sesion.");
            System.out.println("Elige una opcion: ");

            opcion = scan.nextLine();
            hacerOpcion(opcion);
        } while ((estaLogueado()));
    }

    public void hacerOpcion(String opcion) {
        switch (opcion) {
            case "0":
                super.seDeslogueo();
                break;
            case "1":
                mostrarInformacion();
                break;
            case "2":
                //verMisProyectos();
                break;

        }
    }

    @Override
    public void addProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
