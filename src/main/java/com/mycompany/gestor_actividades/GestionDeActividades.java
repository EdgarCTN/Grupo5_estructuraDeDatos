/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestor_actividades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */

import java.util.List;


public class GestionDeActividades {

    private ArbolAVL arbolActividades;

    public GestionDeActividades() {
        arbolActividades = new ArbolAVL();
        arbolActividades.insertar(new String[]{"Actividad 1", "Descripción 1", "4", "55 minutos"});
        arbolActividades.insertar(new String[]{"Actividad 2", "Descripción 2", "5", "2 horas"});
        arbolActividades.insertar(new String[]{"Actividad 3", "Descripción 3", "1", "20 minutos"});
        arbolActividades.insertar(new String[]{"Actividad 4", "Descripción 4", "3", "60 minutos"});
    }

    public String[][] obtenerDatosActividades() {
        List<String[]> actividades = arbolActividades.obtenerActividades();
        return actividades.toArray(new String[0][0]);
    }

    public boolean eliminarActividad(String nombreActividad) {
        return arbolActividades.eliminar(nombreActividad);
    }

    public void modificarActividad(String nombreActividad, String nuevaDescripcion) {
        arbolActividades.modificar(nombreActividad, nuevaDescripcion);
    }

    public int contarActividades() {
        return arbolActividades.contarActividades();
    }

    public int contarTareasPrioridadCinco() {
        return arbolActividades.contarTareasPrioridadCinco();
    }

    public int tiempoTotalTareas() {
        return arbolActividades.tiempoTotalTareas();
    }
}




