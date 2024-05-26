/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pantallasDeInterfaz;

import com.mycompany.gestor_actividades.GestionDeActividades;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class pantallaInicio extends javax.swing.JPanel {
    private GestionDeActividades gestionDeActividades;

    /**
     * Creates new form pantallaInicio
     */
    public pantallaInicio() {
        initComponents();
        iniciarEstilos();
        actualizarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contenedor1 = new javax.swing.JPanel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        texto3 = new javax.swing.JLabel();
        texto4 = new javax.swing.JLabel();
        texto5 = new javax.swing.JLabel();
        imagen_1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        contenedor1.setBackground(new java.awt.Color(51, 153, 255));
        contenedor1.setName(""); // NOI18N

        texto1.setText("Resumen actual:");

        texto2.setText("1) Numero de tareas: ???");

        texto3.setText("2) Numero de tareas de alta prioridad: ??? ");

        texto4.setText("3) Tiempo total de trabajo: ???");

        texto5.setText("4) Numero total de subtareas: ???");

        javax.swing.GroupLayout contenedor1Layout = new javax.swing.GroupLayout(contenedor1);
        contenedor1.setLayout(contenedor1Layout);
        contenedor1Layout.setHorizontalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor1Layout.createSequentialGroup()
                .addGroup(contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedor1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(146, 146, 146))
                    .addGroup(contenedor1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedor1Layout.createSequentialGroup()
                                .addComponent(texto5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(46, 46, 46))
                            .addComponent(texto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(119, 119, 119))
        );
        contenedor1Layout.setVerticalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(texto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(texto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(texto4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(texto5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );

        imagen_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/informe-seo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(contenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagen_1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, Short.MAX_VALUE)
                .addGap(143, 143, 143))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(imagen_1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(contenedor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(149, 149, 149))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void iniciarEstilos(){
        //Coleres de textos
        texto1.putClientProperty( "FlatLaf.styleClass", "h1" );
        texto1.setForeground(Color.white);
        texto2.putClientProperty( "FlatLaf.styleClass", "h3" );
        texto2.setForeground(Color.white);
        texto3.putClientProperty( "FlatLaf.styleClass", "h3" );
        texto3.setForeground(Color.white);
        texto4.putClientProperty( "FlatLaf.styleClass", "h3" );
        texto4.setForeground(Color.white);
        texto5.putClientProperty( "FlatLaf.styleClass", "h3" );
        texto5.setForeground(Color.white);
    }
 
    private void actualizarDatos() {
        gestionDeActividades = new GestionDeActividades();
        
        int numeroDeTareas = gestionDeActividades.contarActividades();
        int numeroDeTareasAltaPrioridad = gestionDeActividades.contarTareasPrioridadCinco();
        int tiempoTotalTrabajo = gestionDeActividades.tiempoTotalTareas();

        texto2.setText("1) Numero de tareas: " + numeroDeTareas);
        texto3.setText("2) Numero de tareas de alta prioridad: " + numeroDeTareasAltaPrioridad);
        texto4.setText("3) Tiempo total de trabajo: " + tiempoTotalTrabajo + " minutos");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor1;
    private javax.swing.JLabel imagen_1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    private javax.swing.JLabel texto5;
    // End of variables declaration//GEN-END:variables
}
