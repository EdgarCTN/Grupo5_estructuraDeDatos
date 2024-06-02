/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestor_actividades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ArbolAVL {
    private NodoAVL raiz;

    // Obtener la altura de un nodo
    private int altura(NodoAVL n) {
        return n == null ? 0 : n.altura;
    }

    // Obtener el balance de un nodo
    private int obtenerBalance(NodoAVL n) {
        return n == null ? 0 : altura(n.izquierda) - altura(n.derecha);
    }

    // Rotación a la derecha
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    // Rotación a la izquierda
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    // Insertar una nueva actividad
    public void insertar(String[] actividad) {
        raiz = insertarRec(raiz, actividad);
    }

    private NodoAVL insertarRec(NodoAVL nodo, String[] actividad) {
        if (nodo == null) {
            return new NodoAVL(actividad);
        }

        int prioridad = Integer.parseInt(actividad[2]);
        int prioridadNodo = Integer.parseInt(nodo.actividad[2]);

        if (prioridad < prioridadNodo) {
            nodo.izquierda = insertarRec(nodo.izquierda, actividad);
        } else if (prioridad > prioridadNodo) {
            nodo.derecha = insertarRec(nodo.derecha, actividad);
        } else {
            // Si las prioridades son iguales, puede insertar en la izquierda o la derecha
            nodo.izquierda = insertarRec(nodo.izquierda, actividad);
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = obtenerBalance(nodo);

        // Rotaciones para mantener el balance
        if (balance > 1 && prioridad < Integer.parseInt(nodo.izquierda.actividad[2])) {
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && prioridad > Integer.parseInt(nodo.derecha.actividad[2])) {
            return rotacionIzquierda(nodo);
        }

        if (balance > 1 && prioridad > Integer.parseInt(nodo.izquierda.actividad[2])) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && prioridad < Integer.parseInt(nodo.derecha.actividad[2])) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Método para eliminar una actividad
    public boolean eliminar(String nombreActividad) {
        if (raiz == null) return false;
        raiz = eliminarRec(raiz, nombreActividad);
        return true;
    }

    private NodoAVL eliminarRec(NodoAVL nodo, String nombreActividad) {
        if (nodo == null) {
            return nodo;
        }

        if (nombreActividad.compareTo(nodo.actividad[0]) < 0) {
            nodo.izquierda = eliminarRec(nodo.izquierda, nombreActividad);
        } else if (nombreActividad.compareTo(nodo.actividad[0]) > 0) {
            nodo.derecha = eliminarRec(nodo.derecha, nombreActividad);
        } else {
            if ((nodo.izquierda == null) || (nodo.derecha == null)) {
                NodoAVL temp = null;
                if (temp == nodo.izquierda) {
                    temp = nodo.derecha;
                } else {
                    temp = nodo.izquierda;
                }

                if (temp == null) {
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                NodoAVL temp = obtenerMinValorNodo(nodo.derecha);
                nodo.actividad = temp.actividad;
                nodo.derecha = eliminarRec(nodo.derecha, temp.actividad[0]);
            }
        }

        if (nodo == null) return nodo;

        nodo.altura = Math.max(altura(nodo.izquierda), altura(nodo.derecha)) + 1;
        int balance = obtenerBalance(nodo);

        if (balance > 1 && obtenerBalance(nodo.izquierda) >= 0) {
            return rotacionDerecha(nodo);
        }

        if (balance > 1 && obtenerBalance(nodo.izquierda) < 0) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecha) <= 0) {
            return rotacionIzquierda(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecha) > 0) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL obtenerMinValorNodo(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual;
    }

    // Método para obtener todas las actividades
    public List<String[]> obtenerActividades() {
        List<String[]> actividades = new ArrayList<>();
        inOrden(raiz, actividades);
        return actividades;
    }

    private void inOrden(NodoAVL nodo, List<String[]> actividades) {
        if (nodo != null) {
            inOrden(nodo.izquierda, actividades);
            actividades.add(nodo.actividad);
            inOrden(nodo.derecha, actividades);
        }
    }

    // Método para modificar una actividad
    public void modificar(String nombreActividad, String nuevaDescripcion) {
        NodoAVL nodo = buscar(raiz, nombreActividad);
        if (nodo != null) {
            nodo.actividad[1] = nuevaDescripcion;
        }
    }

    private NodoAVL buscar(NodoAVL nodo, String nombreActividad) {
        if (nodo == null || nodo.actividad[0].equals(nombreActividad)) {
            return nodo;
        }

        if (nombreActividad.compareTo(nodo.actividad[0]) < 0) {
            return buscar(nodo.izquierda, nombreActividad);
        }

        return buscar(nodo.derecha, nombreActividad);
    }

    // Método para contar actividades
    public int contarActividades() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
    }

    // Método para contar tareas con prioridad cinco
    public int contarTareasPrioridadCinco() {
        return contarTareasPrioridad(raiz, 5);
    }

    private int contarTareasPrioridad(NodoAVL nodo, int prioridad) {
        if (nodo == null) {
            return 0;
        }

        int prioridadNodo = Integer.parseInt(nodo.actividad[2]);
        int contar = 0;
        if (prioridadNodo == prioridad) {
            contar = 1;
        }

        return contar + contarTareasPrioridad(nodo.izquierda, prioridad) + contarTareasPrioridad(nodo.derecha, prioridad);
    }

    // Método para calcular el tiempo total de todas las tareas
    public int tiempoTotalTareas() {
        return calcularTiempoTotal(raiz);
    }

    private int calcularTiempoTotal(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }

        int totalMinutos = 0;
        String[] tiempo = nodo.actividad[3].split(" ");
        int cantidad = Integer.parseInt(tiempo[0]);
        if (tiempo[1].startsWith("hora")) {
            totalMinutos += cantidad * 60;
        } else if (tiempo[1].startsWith("minuto")) {
            totalMinutos += cantidad;
        }

        return totalMinutos + calcularTiempoTotal(nodo.izquierda) + calcularTiempoTotal(nodo.derecha);
    }
}
