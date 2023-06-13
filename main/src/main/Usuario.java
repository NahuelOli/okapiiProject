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

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        estaLogueado = false;
    }  
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {    
        return password;
    }
    
    public boolean sonIgualesUsers(String username){
        return this.username.equalsIgnoreCase(username);
    } 
    
    public boolean sonIgualesPasswords(String password){
        return this.password.equalsIgnoreCase(password);
    }

    public abstract void verOpciones(Usuario user);
}
