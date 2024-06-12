/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaUsuarios;

import com.mycompany.gestor_actividades.Actividad;
import com.mycompany.gestor_actividades.ArbolAVL;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Usuario implements Serializable {
    private String nombreUsuario;
    private String nombre;
    private String email;
    private String password;
    private ArbolAVL arbolActividades;

    public Usuario(String nombreUsuario, String nombre, String email, String password) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.arbolActividades = new ArbolAVL();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArbolAVL getArbolActividades() {
        return arbolActividades;
    }

    public void setArbolActividades(ArbolAVL arbolActividades) {
        this.arbolActividades = arbolActividades;
    }

    public void guardarArbolActividades() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombre + "_arbolActividades.dat"))) {
            out.writeObject(this.arbolActividades);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarArbolActividades() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombre + "_arbolActividades.dat"))) {
            this.arbolActividades = (ArbolAVL) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
