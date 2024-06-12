/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pantallasDeInterfaz;

import com.mycompany.gestor_actividades.ArbolAVL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import listaUsuarios.Usuario;

/**
 *
 * @author PC
 */
public class pantalla1 extends javax.swing.JPanel {
    private Usuario usuario;

    /**
     * Creates new form pantallaInicio
     */
    public pantalla1(Usuario usuario) {
        this.usuario = usuario;  // Asignar el usuario
        cargarDatos();
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
        imagen_1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textoA = new javax.swing.JLabel();
        textoB = new javax.swing.JLabel();
        textoC = new javax.swing.JLabel();
        textoD = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor1.setBackground(new java.awt.Color(51, 153, 255));
        contenedor1.setName(""); // NOI18N

        texto1.setText("Resumen actual:");

        texto2.setText("1) Numero de tareas: ???");

        texto3.setText("2) Numero de tareas de alta prioridad: ??? ");

        texto4.setText("3) Tiempo total de trabajo: ???");

        javax.swing.GroupLayout contenedor1Layout = new javax.swing.GroupLayout(contenedor1);
        contenedor1.setLayout(contenedor1Layout);
        contenedor1Layout.setHorizontalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto4, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(texto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(texto3, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                .addContainerGap())
        );
        contenedor1Layout.setVerticalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(texto4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(144, 144, 144))
        );

        jPanel1.add(contenedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 350, 170));

        imagen_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/informe-seo.png"))); // NOI18N
        jPanel1.add(imagen_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 58, 244, 238));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        textoA.setText("Datos del usuario");

        textoB.setText("1) Nombre de usuario: ???");

        textoC.setText("2) Nombre: ???");

        textoD.setText("3) Correo electronico: ???");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoD)
                    .addComponent(textoB)
                    .addComponent(textoA)
                    .addComponent(textoC))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(textoA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoD)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void cargarDatos() {
        usuario.cargarArbolActividades();
    }

    
    
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
        
        textoA.putClientProperty( "FlatLaf.styleClass", "h1" );
        textoA.setForeground(Color.white);
        textoB.putClientProperty( "FlatLaf.styleClass", "h3" );
        textoB.setForeground(Color.white);
        textoC.putClientProperty( "FlatLaf.styleClass", "h3" );
        textoC.setForeground(Color.white);
        textoD.putClientProperty( "FlatLaf.styleClass", "h3" );
        textoD.setForeground(Color.white);
    }
 
    private void actualizarDatos() {
        if (usuario.getArbolActividades() == null) {
            usuario.setArbolActividades(new ArbolAVL());
        }

        ArbolAVL arbol = usuario.getArbolActividades();

        int numeroDeTareas = arbol.contarActividades();
        int numeroDeTareasAltaPrioridad = arbol.contarTareasPrioridadCinco();
        int tiempoTotalTrabajo = arbol.tiempoTotalTareas();
        
        textoB.setText("1) Nombre de usuario: " + usuario.getNombreUsuario());
        textoC.setText("2) Nombre: " + usuario.getNombre());
        textoD.setText("3) Correo electronico: " + usuario.getEmail());
        
        texto2.setText("1) Número de tareas: " + numeroDeTareas);
        texto3.setText("2) Número de tareas de alta prioridad: " + numeroDeTareasAltaPrioridad);
        texto4.setText("3) Tiempo total de trabajo: " + tiempoTotalTrabajo + " minutos");
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor1;
    private javax.swing.JLabel imagen_1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    private javax.swing.JLabel textoA;
    private javax.swing.JLabel textoB;
    private javax.swing.JLabel textoC;
    private javax.swing.JLabel textoD;
    // End of variables declaration//GEN-END:variables
}