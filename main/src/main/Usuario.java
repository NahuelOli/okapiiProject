/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;

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

    public boolean estaLogueado() {
        return estaLogueado;
    }

    public void seLogueo() {
        this.estaLogueado = true;
    }

    public void seDeslogueo() {
        this.estaLogueado = false;
    }

    public void cambiarPassword() {
        Scanner scan = new Scanner(System.in);
        String password;
        System.out.println("Ingrese su password actual.");
        password = scan.nextLine();
        if (sonIgualesPasswords(password)) {
            System.out.println("Ingrese su nueva password.");
            password = scan.nextLine();
            setPassword(password);
        } else {
            System.out.println("Password ingresado incorrecto");
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean sonIgualesUsers(String username) {
        return this.username.equalsIgnoreCase(username);
    }

    public boolean sonIgualesPasswords(String password) {
        return this.password.equalsIgnoreCase(password);
    }

    public abstract void verOpciones();
}
