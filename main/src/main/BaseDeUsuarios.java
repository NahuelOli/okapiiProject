/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

public class BaseDeUsuarios {
    ArrayList<Usuario> u;

    public BaseDeUsuarios() {
       u = new ArrayList<>();
    }
    
    public boolean estaVacia(){
        return u.isEmpty();
    }
    
    
}
