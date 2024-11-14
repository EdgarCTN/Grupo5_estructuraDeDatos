package com.mycompany.gestor_actividades;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * La clase ArbolAVL implementa un árbol AVL para gestionar actividades.
 * Incluye métodos para insertar, eliminar, modificar y consultar actividades, 
 * así como obtener recomendaciones de actividades basadas en la fecha límite y prioridad.
 */
public class ArbolAVL implements Serializable {
    private NodoAVL raiz;

    /**
     * Calcula la altura de un nodo.
     * @param n Nodo del cual se quiere obtener la altura.
     * @return Altura del nodo, 0 si el nodo es nulo.
     */
    private int altura(NodoAVL n) {
        return n == null ? 0 : n.altura;
    }

    /**
     * Obtiene el balance de un nodo.
     * @param n Nodo del cual se quiere obtener el balance.
     * @return Balance del nodo, 0 si el nodo es nulo.
     */
    private int obtenerBalance(NodoAVL n) {
        return n == null ? 0 : altura(n.izquierda) - altura(n.derecha);
    }

    /**
     * Realiza una rotación a la derecha sobre un nodo.
     * @param y Nodo sobre el cual se quiere realizar la rotación.
     * @return Nuevo nodo raíz después de la rotación.
     */
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    /**
     * Realiza una rotación a la izquierda sobre un nodo.
     * @param x Nodo sobre el cual se quiere realizar la rotación.
     * @return Nuevo nodo raíz después de la rotación.
     */
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    /**
     * Inserta una nueva actividad en el árbol AVL.
     * @param actividad Actividad a insertar.
     */
    public void insertar(Actividad actividad) {
        raiz = insertarRec(raiz, actividad);
    }

    /**
     * Inserta una nueva actividad de forma recursiva.
     * @param nodo Nodo actual en la recursión.
     * @param actividad Actividad a insertar.
     * @return Nuevo nodo después de la inserción y balanceo.
     */
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

    /**
     * Elimina una actividad del árbol AVL por su nombre.
     * @param nombreActividad Nombre de la actividad a eliminar.
     * @return true si la actividad fue eliminada, false en caso contrario.
     */
    public boolean eliminar(String nombreActividad) {
        if (raiz == null) return false;
        int tamañoInicial = contarActividades();
        raiz = eliminarRec(raiz, nombreActividad);
        int tamañoFinal = contarActividades();
        return tamañoFinal < tamañoInicial;
    }

    /**
     * Elimina una actividad de forma recursiva.
     * @param nodo Nodo actual en la recursión.
     * @param nombreActividad Nombre de la actividad a eliminar.
     * @return Nuevo nodo después de la eliminación y balanceo.
     */
    private NodoAVL eliminarRec(NodoAVL nodo, String nombreActividad) {
        if (nodo == null) return null;

        int comparacionNombre = nombreActividad.compareTo(nodo.actividad.getNombre());
        if (comparacionNombre < 0) {
            nodo.izquierda = eliminarRec(nodo.izquierda, nombreActividad);
        } else if (comparacionNombre > 0) {
            nodo.derecha = eliminarRec(nodo.derecha, nombreActividad);
        } else {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }

            NodoAVL temp = obtenerMinValorNodo(nodo.derecha);
            nodo.actividad = temp.actividad;
            nodo.derecha = eliminarRec(nodo.derecha, temp.actividad.getNombre());
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

    /**
     * Obtiene el nodo con el valor mínimo.
     * @param nodo Nodo desde el cual buscar el valor mínimo.
     * @return Nodo con el valor mínimo.
     */
    private NodoAVL obtenerMinValorNodo(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual;
    }

    /**
     * Obtiene una lista de todas las actividades en el árbol AVL en orden.
     * @return Lista de actividades en orden.
     */
    public List<Actividad> obtenerActividades() {
        List<Actividad> actividades = new ArrayList<>();
        inOrden(raiz, actividades);
        return actividades;
    }

    /**
     * Realiza un recorrido en orden del árbol AVL.
     * @param nodo Nodo actual en la recursión.
     * @param actividades Lista donde se añadirán las actividades.
     */
    private void inOrden(NodoAVL nodo, List<Actividad> actividades) {
        if (nodo != null) {
            inOrden(nodo.izquierda, actividades);
            actividades.add(nodo.actividad);
            inOrden(nodo.derecha, actividades);
        }
    }

    /**
     * Obtiene una lista de actividades recomendadas, ordenadas por fecha límite, prioridad y tiempo estimado.
     * @return Lista de actividades recomendadas.
     */
    public List<Actividad> obtenerActividadesRecomendadas() {
        List<Actividad> actividades = obtenerActividades();

        actividades.sort(new Comparator<Actividad>() {
            @Override
            public int compare(Actividad a1, Actividad a2) {
                Date now = new Date();
                Date limite1 = a1.getFechaLimite();
                Date limite2 = a2.getFechaLimite();

                long diff1 = daysBetween(now, limite1);
                long diff2 = daysBetween(now, limite2);

                if (diff1 <= 2 && diff2 > 2) {
                    return -1;
                } else if (diff2 <= 2 && diff1 > 2) {
                    return 1;
                } else if (diff1 <= 2 && diff2 <= 2) {
                    return limite1.compareTo(limite2);
                }

                int prioridadComparison = Integer.compare(a2.getPrioridad(), a1.getPrioridad());
                if (prioridadComparison != 0) {
                    return prioridadComparison;
                }
                return Integer.compare(a1.getTiempoEstimado(), a2.getTiempoEstimado());
            }

            private long daysBetween(Date d1, Date d2) {
                long diff = d2.getTime() - d1.getTime();
                return diff / (1000 * 60 * 60 * 24);
            }
        });

        return actividades;
    }

    /**
     * Modifica la descripción de una actividad existente.
     * @param nombreActividad Nombre de la actividad a modificar.
     * @param nuevaDescripcion Nueva descripción para la actividad.
     */
    public void modificar(String nombreActividad, String nuevaDescripcion) {
        NodoAVL nodo = buscar(raiz, nombreActividad);
        if (nodo != null) {
            nodo.actividad.setDescripcion(nuevaDescripcion);
        }
    }

    /**
     * Busca un nodo en el árbol AVL por el nombre de la actividad.
     * @param nodo Nodo actual en la recursión.
     * @param nombreActividad Nombre de la actividad a buscar.
     * @return Nodo que contiene la actividad, null si no se encuentra.
     */
    private NodoAVL buscar(NodoAVL nodo, String nombreActividad) {
        if (nodo == null || nodo.actividad.getNombre().equals(nombreActividad)) {
            return nodo;
        }

        if (nombreActividad.compareTo(nodo.actividad.getNombre()) < 0) {
            return buscar(nodo.izquierda, nombreActividad);
        }

        return buscar(nodo.derecha, nombreActividad);
    }

    /**
     * Cuenta el número total de actividades en el árbol AVL.
     * @return Número total de actividades.
     */
    public int contarActividades() {
        return contarNodos(raiz);
    }

    /**
     * Cuenta el número de nodos en el árbol AVL de forma recursiva.
     * @param nodo Nodo actual en la recursión.
     * @return Número de nodos.
     */
    private int contarNodos(NodoAVL nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
    }

    /**
     * Cuenta el número de tareas con prioridad cinco.
     * @return Número de tareas con prioridad cinco.
     */
    public int contarTareasPrioridadCinco() {
        return contarTareasPrioridad(raiz, 5);
    }

    /**
     * Cuenta el número de tareas con una prioridad específica de forma recursiva.
     * @param nodo Nodo actual en la recursión.
     * @param prioridad Prioridad de las tareas a contar.
     * @return Número de tareas con la prioridad especificada.
     */
    private int contarTareasPrioridad(NodoAVL nodo, int prioridad) {
        if (nodo == null) return 0;
        int contar = nodo.actividad.getPrioridad() == prioridad ? 1 : 0;
        return contar + contarTareasPrioridad(nodo.izquierda, prioridad) + contarTareasPrioridad(nodo.derecha, prioridad);
    }

    /**
     * Calcula el tiempo total estimado de todas las tareas en el árbol AVL.
     * @return Tiempo total estimado.
     */
    public int tiempoTotalTareas() {
        return calcularTiempoTotal(raiz);
    }

    /**
     * Calcula el tiempo total estimado de todas las tareas en un subárbol de forma recursiva.
     * @param nodo Nodo actual en la recursión.
     * @return Tiempo total estimado.
     */
    private int calcularTiempoTotal(NodoAVL nodo) {
        if (nodo == null) return 0;
        return nodo.actividad.getTiempoEstimado() + calcularTiempoTotal(nodo.izquierda) + calcularTiempoTotal(nodo.derecha);
    }

    /**
     * Obtiene la raíz del árbol AVL.
     * @return Nodo raíz del árbol AVL.
     */
    public NodoAVL getRaiz() {
        return raiz;
    }

    /**
     * Agrega una subactividad a una actividad existente.
     * @param nombreActividadPadre Nombre de la actividad padre.
     * @param subactividad Subactividad a agregar.
     */
    /**
 * Agrega una subactividad a una actividad existente.
 * @param nombreActividadPadre Nombre de la actividad padre.
 * @param subactividad Subactividad a agregar.
 */
    public void agregarSubactividad(String nombreActividadPadre, Actividad subactividad) {
        // Llama al método recursivo para agregar la subactividad, comenzando desde la raíz del árbol
        raiz = agregarSubactividadRec(raiz, nombreActividadPadre, subactividad);
    }

    /**
     * Agrega una subactividad de forma recursiva.
     * @param nodo Nodo actual en la recursión.
     * @param nombreActividadPadre Nombre de la actividad padre.
     * @param subactividad Subactividad a agregar.
     * @return Nuevo nodo después de agregar la subactividad y balanceo.
     */
    private NodoAVL agregarSubactividadRec(NodoAVL nodo, String nombreActividadPadre, Actividad subactividad) {
        // Si el nodo actual es nulo, devuelve null (no se encontró la actividad padre)
        if (nodo == null) {
            return null;
        }

        // Si el nombre de la actividad padre coincide con el nombre del nodo actual
        if (nombreActividadPadre.equals(nodo.actividad.getNombre())) {
            // Agrega la subactividad a la lista de subactividades de la actividad actual
            nodo.actividad.addSubActividad(subactividad);
            // Devuelve el nodo actual
            return nodo;
        }

        // Si el nombre de la actividad padre es menor que el nombre del nodo actual (comparación alfabética)
        if (nombreActividadPadre.compareTo(nodo.actividad.getNombre()) < 0) {
            // Continua la búsqueda en el subárbol izquierdo
            nodo.izquierda = agregarSubactividadRec(nodo.izquierda, nombreActividadPadre, subactividad);
        } else {
            // Continua la búsqueda en el subárbol derecho
            nodo.derecha = agregarSubactividadRec(nodo.derecha, nombreActividadPadre, subactividad);
        }

        // Actualiza la altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));

        // Obtiene el balance del nodo actual para verificar si está balanceado
        int balance = obtenerBalance(nodo);

        // Si el nodo está desbalanceado a la izquierda
        if (balance > 1) {
            // Si el subárbol izquierdo está desbalanceado a la derecha
            if (obtenerBalance(nodo.izquierda) < 0) {
                // Realiza una rotación a la izquierda en el subárbol izquierdo
                nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            }
            // Realiza una rotación a la derecha en el nodo actual
            return rotacionDerecha(nodo);
        }

        // Si el nodo está desbalanceado a la derecha
        if (balance < -1) {
            // Si el subárbol derecho está desbalanceado a la izquierda
            if (obtenerBalance(nodo.derecha) > 0) {
                // Realiza una rotación a la derecha en el subárbol derecho
                nodo.derecha = rotacionDerecha(nodo.derecha);
            }
            // Realiza una rotación a la izquierda en el nodo actual
            return rotacionIzquierda(nodo);
        }

        // Devuelve el nodo actual después de asegurarse de que esté balanceado
        return nodo;
    }
}


