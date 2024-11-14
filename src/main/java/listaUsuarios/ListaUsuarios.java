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

    /**
     * Agrega un usuario a la lista enlazada de usuarios.
     * @param usuario Usuario a agregar.
     */
    public void agregarUsuario(Usuario usuario) {
        NodoUsuario nuevoNodo = new NodoUsuario(usuario); // Crea un nuevo nodo con el usuario proporcionado
        if (cabeza == null) {
            cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo se convierte en la cabeza de la lista
        } else {
            NodoUsuario actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente; // Recorre la lista hasta el último nodo
            }
            actual.siguiente = nuevoNodo; // Agrega el nuevo nodo al final de la lista
        }
    }

    /**
     * Busca un usuario en la lista por nombre.
     * @param nombre Nombre del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */
    public Usuario buscarUsuario(String nombre) {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            if (actual.usuario.getNombreUsuario().equals(nombre)) {
                return actual.usuario; // Devuelve el usuario si se encuentra
            }
            actual = actual.siguiente; // Pasa al siguiente nodo en la lista
        }
        return null; // Si no se encuentra el usuario, devuelve null
    }

    /**
     * Muestra todos los usuarios en la lista y sus actividades.
     */
    public void mostrarUsuarios() {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            System.out.println(actual.usuario); // Imprime la información del usuario actual
            if (actual.usuario.getArbolActividades() != null) {
                List<Actividad> actividades = actual.usuario.getArbolActividades().obtenerActividades();
                for (Actividad actividad : actividades) {
                    System.out.println(actividad); // Imprime cada actividad del usuario
                }
            }
            actual = actual.siguiente; // Pasa al siguiente nodo en la lista
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