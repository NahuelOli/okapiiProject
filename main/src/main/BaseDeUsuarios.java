/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseDeUsuarios {
    private ArrayList<Usuario> u;
    private int idSetter;

    public BaseDeUsuarios() {
       u = new ArrayList<>();
       idSetter = 0;
    }
    
    public boolean estaVacia(){
        return u.isEmpty();
    }
    
    public boolean chequearUsuario(String user){
        boolean estaDisponible = true;
        Usuario userAComparar;
        if(!estaVacia()){
            int i = 0;
            do{
                userAComparar = u.get(i);
                i++;
            }while(i < u.size() && !userAComparar.sonIgualesUsers(user));
            
            if(userAComparar.sonIgualesUsers(user)){
                estaDisponible = false;
            }
            
            }
            return estaDisponible;
        } 
    


    public void crearUsuario(String user, String password) {
        Usuario usuarioEntrante = new Cliente(user, password);
        if(u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }
}
