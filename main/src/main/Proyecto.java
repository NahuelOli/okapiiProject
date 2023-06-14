package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Proyecto {

    private String estado;
    private double presupuesto;
    private boolean estaFinalizado;
    private String fecha;
    private String nombre;
    private String descripcion;

    public Proyecto(double presupuesto, String nombre, String descrpicion) {
        estado = estaEnAprobacion();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
        estaFinalizado = false;
        this.fecha = asignarFecha();
    }

    private String asignarFecha() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fecha.format(formatObj);
    }

    private String estaEnAprobacion() {
        estado = "En espera de aprobacion.";
        return estado;
    }

    private String estaSinFinalizar() {
        estado = "Sin finalizar.";
        return estado;
    }

    private String estaFinalizado() {
        estado = "Finalizado.";
        estaFinalizado = true;
        return estado;
    }

    private void mostrarEstado() {
        System.out.println("Estado del proyecto: " + estado);
    }

    private void mostrarNombre() {
        System.out.println(nombre);
    }

    private void mostrarDescripcion() {
        System.out.println(descripcion);
    }
}
