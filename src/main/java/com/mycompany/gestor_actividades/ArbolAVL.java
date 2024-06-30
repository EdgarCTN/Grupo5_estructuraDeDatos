package com.mycompany.gestor_actividades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ArbolAVL implements Serializable {
    private NodoAVL raiz;

    private int altura(NodoAVL n) {
        return n == null ? 0 : n.altura;
    }

    private int obtenerBalance(NodoAVL n) {
        return n == null ? 0 : altura(n.izquierda) - altura(n.derecha);
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    public void insertar(Actividad actividad) {
        raiz = insertarRec(raiz, actividad);
    }

    private NodoAVL insertarRec(NodoAVL nodo, Actividad actividad) {
        if (nodo == null) {
            return new NodoAVL(actividad);
        }

        int comparacionFecha = actividad.getFechaLimite().compareTo(nodo.actividad.getFechaLimite());
        if (comparacionFecha < 0) {
            nodo.izquierda = insertarRec(nodo.izquierda, actividad);
        } else if (comparacionFecha > 0) {
            nodo.derecha = insertarRec(nodo.derecha, actividad);
        } else {
            int comparacionPrioridad = Integer.compare(actividad.getPrioridad(), nodo.actividad.getPrioridad());
            if (comparacionPrioridad != 0) {
                nodo = comparacionPrioridad > 0 ? insertarRec(nodo.izquierda, actividad) : insertarRec(nodo.derecha, actividad);
            } else {
                int comparacionTiempo = Integer.compare(actividad.getTiempoEstimado(), nodo.actividad.getTiempoEstimado());
                if (comparacionTiempo != 0) {
                    nodo = comparacionTiempo > 0 ? insertarRec(nodo.izquierda, actividad) : insertarRec(nodo.derecha, actividad);
                } else {
                    String mensaje = "Las actividades son iguales en fecha, prioridad y tiempo estimado:\n"
                            + "Actividad existente: " + nodo.actividad + "\n"
                            + "Nueva actividad: " + actividad + "\n"
                            + "¿Desea insertar la nueva actividad a la izquierda o a la derecha?";

                    Object[] opciones = {"Izquierda", "Derecha"};
                    int decision = JOptionPane.showOptionDialog(null, mensaje, "Decisión de inserción",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                    if (decision == 0) {
                        nodo.izquierda = insertarRec(nodo.izquierda, actividad);
                    } else {
                        nodo.derecha = insertarRec(nodo.derecha, actividad);
                    }
                }
            }
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));

        int balance = obtenerBalance(nodo);

        if (balance > 1) {
            if (obtenerBalance(nodo.izquierda) < 0) {
                nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            }
            return rotacionDerecha(nodo);
        }

        if (balance < -1) {
            if (obtenerBalance(nodo.derecha) > 0) {
                nodo.derecha = rotacionDerecha(nodo.derecha);
            }
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public boolean eliminar(String nombreActividad) {
        if (raiz == null) return false;
        raiz = eliminarRec(raiz, nombreActividad);
        return raiz != null;
    }

    private NodoAVL eliminarRec(NodoAVL nodo, String nombreActividad) {
        if (nodo == null) return null;

        int comparacionNombre = nombreActividad.compareTo(nodo.actividad.getNombre());
        if (comparacionNombre < 0) {
            nodo.izquierda = eliminarRec(nodo.izquierda, nombreActividad);
        } else if (comparacionNombre > 0) {
            nodo.derecha = eliminarRec(nodo.derecha, nombreActividad);
        } else {
            if (nodo.izquierda == null || nodo.derecha == null) {
                nodo = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;
            } else {
                NodoAVL temp = obtenerMinValorNodo(nodo.derecha);
                nodo.actividad = temp.actividad;
                nodo.derecha = eliminarRec(nodo.derecha, temp.actividad.getNombre());
            }
        }

        if (nodo == null) return nodo;

        nodo.altura = Math.max(altura(nodo.izquierda), altura(nodo.derecha)) + 1;

        int balance = obtenerBalance(nodo);

        if (balance > 1) {
            if (obtenerBalance(nodo.izquierda) < 0) {
                nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            }
            return rotacionDerecha(nodo);
        }

        if (balance < -1) {
            if (obtenerBalance(nodo.derecha) > 0) {
                nodo.derecha = rotacionDerecha(nodo.derecha);
            }
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

    public List<Actividad> obtenerActividades() {
        List<Actividad> actividades = new ArrayList<>();
        inOrden(raiz, actividades);
        return actividades;
    }

    private void inOrden(NodoAVL nodo, List<Actividad> actividades) {
        if (nodo != null) {
            inOrden(nodo.izquierda, actividades);
            actividades.add(nodo.actividad);
            inOrden(nodo.derecha, actividades);
        }
    }

    public void modificar(String nombreActividad, String nuevaDescripcion) {
        NodoAVL nodo = buscar(raiz, nombreActividad);
        if (nodo != null) {
            nodo.actividad.setDescripcion(nuevaDescripcion);
        }
    }

    private NodoAVL buscar(NodoAVL nodo, String nombreActividad) {
        if (nodo == null || nodo.actividad.getNombre().equals(nombreActividad)) {
            return nodo;
        }

        if (nombreActividad.compareTo(nodo.actividad.getNombre()) < 0) {
            return buscar(nodo.izquierda, nombreActividad);
        }

        return buscar(nodo.derecha, nombreActividad);
    }

    public int contarActividades() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoAVL nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
    }

    public int contarTareasPrioridadCinco() {
        return contarTareasPrioridad(raiz, 5);
    }

    private int contarTareasPrioridad(NodoAVL nodo, int prioridad) {
        if (nodo == null) return 0;
        int contar = nodo.actividad.getPrioridad() == prioridad ? 1 : 0;
        return contar + contarTareasPrioridad(nodo.izquierda, prioridad) + contarTareasPrioridad(nodo.derecha, prioridad);
    }

    public int tiempoTotalTareas() {
        return calcularTiempoTotal(raiz);
    }

    private int calcularTiempoTotal(NodoAVL nodo) {
        if (nodo == null) return 0;
        return nodo.actividad.getTiempoEstimado() + calcularTiempoTotal(nodo.izquierda) + calcularTiempoTotal(nodo.derecha);
    }

    public NodoAVL getRaiz() {
        return raiz;

}}

