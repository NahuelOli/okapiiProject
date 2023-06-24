package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Proyecto implements Serializable {

    private String estado;
    private String presupuesto;
    private boolean estaFinalizado;
    private String fecha;
    private String nombre;
    private String descripcion;
    private ArrayList<Desarrollador> desarrolladores;

    public Proyecto(String nombre, String descripcion, String presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
        estaFinalizado = false;
        this.fecha = asignarFecha();
        desarrolladores = new ArrayList<>();
    }

    private String asignarFecha() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fecha.format(formatObj);
    }

    public boolean getEstado() {
        return estaFinalizado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String estaSinFinalizar() {
        setEstado("Sin finalizar");
        return estado;
    }

    public String estaFinalizado() {
        setEstado("Finalizado");
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean tieneDesarrolladores() {
        return !desarrolladores.isEmpty();
    }

    public void setDesarrollador(Desarrollador dev) {
        dev.setEstaDisponible(false);
        desarrolladores.add(dev);
    }

    public void mostrarDesarrolladores() {
        System.out.println("Los desarrolladores a cargo del proyecto son: ");
        for (Desarrollador dev : desarrolladores) {
            System.out.println(desarrolladores.indexOf(dev) + ") " + dev.getNombre());
        }
    }

}
