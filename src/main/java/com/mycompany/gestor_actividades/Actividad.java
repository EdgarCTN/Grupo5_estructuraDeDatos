package com.mycompany.gestor_actividades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Clase para almacenar las actividades y luego guardarlas
//Relleno
public class Actividad implements Serializable {
    private String nombre;
    private String dato;
    private String descripcion;
    private Date fechaLimite;
    private int tiempoEstimado;
    private int prioridad;
    private List<Actividad> subActividades;

    public Actividad(String nombre, String descripcion, Date fechaLimite, int tiempoEstimado, int prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.tiempoEstimado = tiempoEstimado;
        this.prioridad = prioridad;
        this.subActividades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public List<Actividad> getSubActividades() {
        return subActividades;
    }

    public void addSubActividad(Actividad subActividad) {
        this.subActividades.add(subActividad);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n 1) Nombre=").append(nombre);
        sb.append("\n 2) Descripcion=").append(descripcion);
        sb.append("\n 3) Fecha Limite=").append(fechaLimite);
        sb.append("\n 4) Tiempo Estimado=").append(tiempoEstimado);
        sb.append("\n 5) Prioridad=").append(prioridad);
        sb.append("\n 6) SubActividades=").append(subActividades.size()).append("\n");
        for (Actividad subActividad : subActividades) {
            sb.append("    ").append(subActividad.toString()).append("\n");
        }
        return sb.toString();
    }
}
