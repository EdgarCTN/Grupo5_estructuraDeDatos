/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestor_actividades;

/**
 *
 * @author PC
 */
import java.io.Serializable;
import java.util.Date;

public class Actividad implements Serializable {
    private String nombre;
    private String descripcion;
    private Date fechaLimite;
    private int tiempoEstimado;
    private int prioridad;

    public Actividad(String nombre, String descripcion, Date fechaLimite, int tiempoEstimado, int prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.tiempoEstimado = tiempoEstimado;
        this.prioridad = prioridad;
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

    @Override
    public String toString() {
        return "\n 1) Nombre=" + nombre +
               "\n 2) Descripcion=" + descripcion +
               "\n 3) Fecha Limite=" + fechaLimite +
               "\n 4) TiempoEstimado=" + tiempoEstimado +
               "\n 5) Prioridad=" + prioridad;
    }
}
