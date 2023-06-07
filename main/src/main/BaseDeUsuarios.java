/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseDeUsuarios {
    ArrayList<Usuario> u;
    Scanner scan =new Scanner(System.in);
    /*
    public void crearUsuario(){
        System.out.println("Ingrese su nuevo nombre de usuario: ");
        this.username = scan.nextLine();
        System.out.println("Ingrese su nueva contrasena: ");
        this.password = scan.nextLine();
        System.out.println("Su nuevo usuario es: "+username+"\nSu nueva contrasena es: "+password);
    }
    */
    public BaseDeUsuarios() {
       u = new ArrayList<>();
    }
    
    public boolean estaVacia(){
        return u.isEmpty();
    }
    
    
}
