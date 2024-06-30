    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.mycompany.gestor_actividades;

    import java.io.Serializable;

    /**
     *
     * @author PC
     */
    public class NodoAVL implements Serializable {
        public Actividad actividad;
        public NodoAVL izquierda, derecha;
        public int altura;

        public NodoAVL(Actividad actividad) {
            this.actividad = actividad;
            this.altura = 1;
        }
        public Actividad getActividad() {
        return actividad;
    }

        public void setActividad(Actividad actividad) {
            this.actividad = actividad;
        }

        public NodoAVL getIzquierda() {
            return izquierda;
        }

        public void setIzquierda(NodoAVL izquierda) {
            this.izquierda = izquierda;
        }

        public NodoAVL getDerecha() {
            return derecha;
        }

        public void setDerecha(NodoAVL derecha) {
            this.derecha = derecha;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }
    }

