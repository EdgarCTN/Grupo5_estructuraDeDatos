package com.mycompany.gestor_actividades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
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
        // Las fechas son iguales, continuar insertando en el subárbol derecho
        nodo.derecha = insertarRec(nodo.derecha, actividad);
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
public List<Actividad> obtenerActividadesRecomendadas() {
        List<Actividad> actividades = obtenerActividades();

        actividades.sort(new Comparator<Actividad>() {
            @Override
            public int compare(Actividad a1, Actividad a2) {
                Date now = new Date();
                Date limite10 = a1.getFechaLimite();
                Date limite20 = a2.getFechaLimite();

                // Comparación por fecha límite (menos de 2 días)
                long diff1 = (limite10.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
                long diff2 = (limite20.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);

                if (diff1 <= 2 && diff2 <= 2) {
                    return limite10.compareTo(limite20);
                }

                // Comparación por prioridad
                int prioridadComparison = Integer.compare(a2.getPrioridad(), a1.getPrioridad());
                if (prioridadComparison != 0) {
                    return prioridadComparison;
                }

                // Comparación por tiempo estimado
                return Integer.compare(a1.getTiempoEstimado(), a2.getTiempoEstimado());
            }
        });

        return actividades;
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

    }
    public void agregarSubactividad(String nombreActividadPadre, Actividad subactividad) {
    raiz = agregarSubactividadRec(raiz, nombreActividadPadre, subactividad);
    }

    private NodoAVL agregarSubactividadRec(NodoAVL nodo, String nombreActividadPadre, Actividad subactividad) {
        if (nodo == null) {
            return null;
        }

        if (nombreActividadPadre.equals(nodo.actividad.getNombre())) {
            nodo.actividad.addSubActividad(subactividad);
            return nodo;
        }

        if (nombreActividadPadre.compareTo(nodo.actividad.getNombre()) < 0) {
            nodo.izquierda = agregarSubactividadRec(nodo.izquierda, nombreActividadPadre, subactividad);
        } else {
            nodo.derecha = agregarSubactividadRec(nodo.derecha, nombreActividadPadre, subactividad);
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
}

