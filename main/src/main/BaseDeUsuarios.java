/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

public class BaseDeUsuarios {

    private ArrayList<Usuario> u;
    private int idSetter;

    public BaseDeUsuarios() {
        u = new ArrayList<>();
        idSetter = 0;
    }

    public boolean estaVacia() {
        return u.isEmpty();
    }

    public boolean chequearUsuario(String user) {
        boolean estaDisponible = true;
        Usuario userAComparar;
        if (!estaVacia()) {
            int i = 0;
            do {
                userAComparar = u.get(i);
                i++;
            } while (i < u.size() && !userAComparar.sonIgualesUsers(user));

            if (userAComparar.sonIgualesUsers(user)) {
                estaDisponible = false;
            }

        }
        return estaDisponible;
    }

    public Usuario buscarUsuario(String username) {
        Usuario userBuscado = null;
        int i = 0;
        if (!estaVacia()) {
            do {
                userBuscado = u.get(i);
                i++;
            } while (i < u.size() && !userBuscado.sonIgualesUsers(username));

            if (!(i < u.size()) && !userBuscado.sonIgualesUsers(username)) {
                userBuscado = null;
            }
        }

        return userBuscado;
    }

    public void crearUsuario(String user, String password) {
        idSetter++;
        Usuario usuarioEntrante = new Cliente(user, password, idSetter);
        if (u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }
}
