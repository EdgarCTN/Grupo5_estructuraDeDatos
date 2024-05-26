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

import java.util.ArrayList;
import java.util.List;

public class GestionDeActividades {

    private List<String[]> actividades;

    public GestionDeActividades() {
        actividades = new ArrayList<>();
        actividades.add(new String[]{"Actividad 1", "Descripción 1", "4", "55 minutos"});
        actividades.add(new String[]{"Actividad 2", "Descripción 2", "5", "2 horas"});
        actividades.add(new String[]{"Actividad 3", "Descripción 3", "1", "20 minutos"});
        actividades.add(new String[]{"Actividad 4", "Descripción 4", "3", "60 minutos"});
    }

    public String[][] obtenerDatosActividades() {
        return actividades.toArray(new String[0][0]);
    }

    public boolean eliminarActividad(String nombreActividad) {
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i)[0].equals(nombreActividad)) {
                actividades.remove(i);
                return true;
            }
        }
        return false;
    }

    public void modificarActividad(String nombreActividad, String nuevaDescripcion) {
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i)[0].equals(nombreActividad)) {
                actividades.get(i)[1] = nuevaDescripcion;
                return;
            }
        }
    }

    public int contarActividades() {
        return actividades.size();
    }

    public int contarTareasPrioridadCinco() {
        int contador = 0;
        for (String[] actividad : actividades) {
            if ("5".equals(actividad[2])) {
                contador++;
            }
        }
        return contador;
    }

    public int tiempoTotalTareas() {
        int totalMinutos = 0;
        for (String[] actividad : actividades) {
            String[] tiempo = actividad[3].split(" ");
            int cantidad = Integer.parseInt(tiempo[0]);
            if (tiempo[1].startsWith("hora")) {
                totalMinutos += cantidad * 60;
            } else if (tiempo[1].startsWith("minuto")) {
                totalMinutos += cantidad;
            }
        }
        return totalMinutos;
    }
}
