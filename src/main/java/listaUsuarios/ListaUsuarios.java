/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaUsuarios;

import com.mycompany.gestor_actividades.Actividad;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PC
 */
public class ListaUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    private NodoUsuario cabeza;

    private static class NodoUsuario implements Serializable {
        private static final long serialVersionUID = 1L;
        Usuario usuario;
        NodoUsuario siguiente;

        public NodoUsuario(Usuario usuario) {
            this.usuario = usuario;
            this.siguiente = null;
        }
    }

    public ListaUsuarios() {
        this.cabeza = null;
    }

    public void agregarUsuario(Usuario usuario) {
        NodoUsuario nuevoNodo = new NodoUsuario(usuario);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoUsuario actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public Usuario buscarUsuario(String nombre) {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            if (actual.usuario.getNombreUsuario().equals(nombre)) {
                return actual.usuario;
            }
            actual = actual.siguiente;
        }
        return null; // Si no se encuentra el usuario
    }

    public void mostrarUsuarios() {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            System.out.println(actual.usuario);
            if (actual.usuario.getArbolActividades() != null) {
                List<Actividad> actividades = actual.usuario.getArbolActividades().obtenerActividades();
                for (Actividad actividad : actividades) {
                    System.out.println(actividad);
                }
            }
            actual = actual.siguiente;
        }
    }

    public void serializarLista(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ListaUsuarios deserializarLista(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ListaUsuarios) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}