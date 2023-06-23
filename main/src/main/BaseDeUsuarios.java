package main;

import java.util.ArrayList;

public class BaseDeUsuarios {

    private ArrayList<Desarrollador> devs;
    private ArrayList<Usuario> u;

    public BaseDeUsuarios() {
        u = new ArrayList<>();
        devs = new ArrayList<>();
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
        Cliente usuarioEntrante = new Cliente(user, password, u.size() + 1, "cliente");
        if (u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }

    public void crearUsuarioGerente(String user, String password) {
        Gerente usuarioEntrante = new Gerente(user, password, "gerente", u);
        if (u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }

    public void crearUsuarioAdministrador(String user, String password) {
        Administrador usuarioEntrante = new Administrador(user, password, u, devs, "admin");
        if (u.add(usuarioEntrante)) {
            System.out.println("Usuario creado con exito.");
        }
    }
}
