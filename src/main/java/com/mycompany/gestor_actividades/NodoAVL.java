/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestor_actividades;

/**
 *
 * @author PC
 */
public class NodoAVL {
    String[] actividad;
    int altura;
    NodoAVL izquierda, derecha;

    NodoAVL(String[] actividad) {
        this.actividad = actividad;
        this.altura = 1;
    }
}
