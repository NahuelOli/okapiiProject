package main;

import java.util.ArrayList;

public class Desarrollador {

    private ArrayList<String> habilidades;
    private String nombre;
    private boolean estaDisponible;

    public Desarrollador(String nombre, ArrayList habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
        estaDisponible = true;

    }

    public boolean getEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    public String getNombre() {
        return nombre;
    }
    
}
