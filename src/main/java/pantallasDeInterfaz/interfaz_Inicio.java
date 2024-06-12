/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallasDeInterfaz;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.UIManager;
import listaUsuarios.Usuario;
import listaUsuarios.loginUsuario;
import pantallasDeInterfaz.crearActividad;
import pantallasDeInterfaz.pantalla2;
import pantallasDeInterfaz.pantalla3;
import pantallasDeInterfaz.pantalla4;
import pantallasDeInterfaz.pantalla1;

/**
 *
 * @author PC
 */
public class interfaz_Inicio extends javax.swing.JFrame {
    private Usuario usuario;
    /**
     * Creates new form interfaz_Inicio
     */
    public interfaz_Inicio(Usuario usuario) {
        this.usuario = usuario;  
        initComponents();
        iniciarEstilos();
        setDate();
        iniciarContenido();
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
        barraHorizontal = new javax.swing.JPanel();
        boton4 = new javax.swing.JButton();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        linea = new javax.swing.JPanel();
        mensajeFunciones = new javax.swing.JLabel();
        barraVertical = new javax.swing.JPanel();
        texto2 = new javax.swing.JLabel();
        texto3 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        crearActividad = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        barraHorizontal.setBackground(new java.awt.Color(0, 102, 255));
        barraHorizontal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton4.setBackground(new java.awt.Color(51, 153, 255));
        boton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/recomendacion.png"))); // NOI18N
        boton4.setText("Recomendaciones");
        boton4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        boton4.setBorderPainted(false);
        boton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton4.setIconTextGap(15);
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        barraHorizontal.add(boton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 60));

        boton1.setBackground(new java.awt.Color(51, 153, 255));
        boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/pagina-de-inicio.png"))); // NOI18N
        boton1.setText(" Inicio");
        boton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        boton1.setBorderPainted(false);
        boton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton1.setIconTextGap(15);
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        barraHorizontal.add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 60));

        boton2.setBackground(new java.awt.Color(51, 153, 255));
        boton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/asignaturas.png"))); // NOI18N
        boton2.setText("General");
        boton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        boton2.setBorderPainted(false);
        boton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton2.setIconTextGap(15);
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        barraHorizontal.add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 60));

        boton3.setBackground(new java.awt.Color(51, 153, 255));
        boton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/investigacion.png"))); // NOI18N
        boton3.setText("Sub tareas");
        boton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        boton3.setBorderPainted(false);
        boton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton3.setIconTextGap(15);
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        barraHorizontal.add(boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 60));

        javax.swing.GroupLayout lineaLayout = new javax.swing.GroupLayout(linea);
        linea.setLayout(lineaLayout);
        lineaLayout.setHorizontalGroup(
            lineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        lineaLayout.setVerticalGroup(
            lineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        barraHorizontal.add(linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 4));

        mensajeFunciones.setText("Funciones");
        barraHorizontal.add(mensajeFunciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 70, -1));

        barraVertical.setBackground(new java.awt.Color(51, 153, 255));

        texto2.setText("Hoy es dia de mes del ???");

        texto3.setText("Comienza haciendo lo que es necesario, después lo que es posible y de repente estarás haciendo lo imposible");

        javax.swing.GroupLayout barraVerticalLayout = new javax.swing.GroupLayout(barraVertical);
        barraVertical.setLayout(barraVerticalLayout);
        barraVerticalLayout.setHorizontalGroup(
            barraVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraVerticalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(barraVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto3)
                    .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        barraVerticalLayout.setVerticalGroup(
            barraVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraVerticalLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(texto2)
                .addGap(18, 18, 18)
                .addComponent(texto3)
                .addGap(28, 28, 28))
        );

        titulo.setText("Gestor de actividades - Grupo 5");

        contenido.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        crearActividad.setText("Crear actividad");
        crearActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActividadActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(barraVertical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(titulo))
                    .addComponent(barraHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crearActividad)
                .addGap(34, 34, 34)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraHorizontal, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(titulo)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crearActividad)
                            .addComponent(botonSalir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(barraVertical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void iniciarEstilos(){
        //Coleres de textos
        titulo.putClientProperty( "FlatLaf.styleClass", "h1" );
        titulo.setForeground(Color.black);
 
        
        texto2.putClientProperty( "FlatLaf.styleClass", "h1" );
        texto2.setForeground(Color.white);
        texto3.putClientProperty( "FlatLaf.styleClass", "h3" );
        texto3.setForeground(Color.white);
        mensajeFunciones.putClientProperty( "FlatLaf.styleClass", "h3" );
        mensajeFunciones.setForeground(Color.white);
        //Color de botones
        boton1.setForeground(Color.black);
        boton2.setForeground(Color.black);
        boton3.setForeground(Color.black);
        boton4.setForeground(Color.black);
        crearActividad.setForeground(Color.black);
        botonSalir.setForeground(Color.black);



    }
    private void setDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        texto2.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    private void iniciarContenido(){
        pantalla1 p1= new pantalla1(usuario);
        p1.setSize(800,445);
        p1.setLocation(0,0);
        contenido.removeAll();
        contenido.add(p1,BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
        
    }

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        pantalla4 p1= new pantalla4();
        p1.setSize(800,445);
        p1.setLocation(0,0);
        contenido.removeAll();
        contenido.add(p1,BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
               

    }//GEN-LAST:event_boton4ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        pantalla2 p1= new pantalla2( usuario);
        p1.setSize(800,445);
        p1.setLocation(0,0);
        contenido.removeAll();
        contenido.add(p1,BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
        
            }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        pantalla3 p1= new pantalla3();
        p1.setSize(800,445);
        p1.setLocation(0,0);
        contenido.removeAll();
        contenido.add(p1,BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();       
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        iniciarContenido();
    }//GEN-LAST:event_boton1ActionPerformed

    private void crearActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActividadActionPerformed
        crearActividad newframe = new crearActividad(usuario);
        newframe.setVisible(true);
        this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_crearActividadActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        loginUsuario newframe = new loginUsuario();
        newframe.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_botonSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
        UIManager.put("Button.arc",999);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario("nombreUsuario","nombreUsuario", "email", "password");
                new interfaz_Inicio( usuario).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraHorizontal;
    private javax.swing.JPanel barraVertical;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPanel contenido;
    private javax.swing.JButton crearActividad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel linea;
    private javax.swing.JLabel mensajeFunciones;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
