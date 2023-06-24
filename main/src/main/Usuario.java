/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Usuario implements Serializable {

    private String username;
    private String password;
    private boolean estaLogueado;
    private String identificador;

    public Usuario(String username, String password, String identificador) {
        this.username = username;
        this.password = password;
        this.identificador = identificador;
        estaLogueado = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIdentificador() {
        return identificador;
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
        System.out.println("Ingrese su clave actual:");
        password = scan.nextLine();
        if (sonIgualesPasswords(password)) {
            System.out.println("Ingrese su nueva clave:");
            password = scan.nextLine();
            setPassword(password);
        } else {
            System.out.println("La clave ingresada es incorrecta.\n\n");
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
