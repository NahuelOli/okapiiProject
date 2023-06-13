/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author SirLucho
 */
public class Cliente extends Usuario{
    private int id;
    private String nombre;
        
    public Cliente(String username, String password){
        super(username, password);
    }

    public void setId(int id) {
        this.id = id;
    }   
    
    public void completarDatos(){
        while(nombre.isBlank()){
            Scanner scan = new Scanner(System.in);
            String nombre;
            System.out.println("Por favor, completa con tu nombre de pila: ");
            nombre = scan.nextLine();
        }
    }
    
    @Override
    public void verOpciones(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
