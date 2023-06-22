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

    public void crearUsuarioCliente(String user, String password) {
        idSetter++;
        Usuario usuarioEntrante = new Cliente(user, password, idSetter, "cliente");
        if (u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }

    void crearUsuarioGerente(String user, String password) {
        Usuario usuarioEntrante = new Gerente(user, password, "gerente", u);
        if (u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }

    void crearUsuarioAdministrador(String user, String password) {
        Usuario usuarioEntrante = new Administrador(user, password, u, "admin");
        if (u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }
}
