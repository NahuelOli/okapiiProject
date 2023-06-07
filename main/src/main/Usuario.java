/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Alumno
 */
public abstract class Usuario {
    private String username;
    private String password;
    private boolean estaLogueado;
    private String nombre;
    
    /*
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
        estaLogueado = false;
    }*/
    
    public abstract void verOpciones(Usuario user);
}
