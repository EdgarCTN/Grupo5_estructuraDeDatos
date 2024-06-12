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
    Actividad actividad;
    NodoAVL izquierda, derecha;
    int altura;

    public NodoAVL(Actividad actividad) {
        this.actividad = actividad;
        this.altura = 1;
    }
}

