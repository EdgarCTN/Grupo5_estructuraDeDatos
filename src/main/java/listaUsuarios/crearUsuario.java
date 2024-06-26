/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package listaUsuarios;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class crearUsuario extends javax.swing.JFrame {
    private static ListaUsuarios listaUsuarios;

    /**
     * Creates new form crearUsuario
     */
    public crearUsuario() {
        listaUsuarios = ListaUsuarios.deserializarLista("usuarios.ser");
        if (listaUsuarios == null) {
            listaUsuarios = new ListaUsuarios();
        }
        initComponents();
        iniciarEstilos();
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
        jPanel2 = new javax.swing.JPanel();
        etiquetaRegistrarse = new javax.swing.JLabel();
        etiquetaUsuario = new javax.swing.JLabel();
        etiquetaEmail = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        textoEmail = new javax.swing.JTextField();
        botonRegistrar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        etiquetaNombre = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        etiquetaPassword = new javax.swing.JLabel();
        textoPassword = new javax.swing.JPasswordField();
        etiquetaImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        etiquetaRegistrarse.setText("Registrarse");

        etiquetaUsuario.setText("Usuario");

        etiquetaEmail.setText("Email");

        botonRegistrar.setText("Crear cuenta");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        etiquetaNombre.setText("Nombre");

        etiquetaPassword.setText("Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaEmail)
                            .addComponent(etiquetaUsuario)
                            .addComponent(etiquetaNombre)
                            .addComponent(etiquetaPassword))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoPassword)
                            .addComponent(etiquetaRegistrarse)
                            .addComponent(textoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(textoEmail)
                            .addComponent(textoNombre))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiquetaRegistrarse)
                        .addGap(44, 44, 44)
                        .addComponent(etiquetaUsuario))
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPassword)
                    .addComponent(textoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(botonRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRegresar)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/registro.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(etiquetaImagen)
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(etiquetaImagen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        etiquetaRegistrarse.putClientProperty( "FlatLaf.styleClass", "h1" );
        etiquetaRegistrarse.setForeground(Color.white);
 
        
        etiquetaUsuario.putClientProperty( "FlatLaf.styleClass", "h3" );
        etiquetaUsuario.setForeground(Color.white);
        etiquetaNombre.putClientProperty( "FlatLaf.styleClass", "h3" );
        etiquetaNombre.setForeground(Color.white);
        etiquetaEmail.putClientProperty( "FlatLaf.styleClass", "h3" );
        etiquetaEmail.setForeground(Color.white);
        etiquetaPassword.putClientProperty( "FlatLaf.styleClass", "h3" );
        etiquetaPassword.setForeground(Color.white);
        //Color de botones
        botonRegistrar.setForeground(Color.black);
        botonRegresar.setForeground(Color.black);


    }
    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        String nombreUsuario = textoUsuario.getText();
        String nombre = textoNombre.getText();
        String email = textoEmail.getText();
        String password = textoPassword.getText();

        if (nombre.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Usuario nuevoUsuario = new Usuario(nombreUsuario,nombre,email,password);
            listaUsuarios.agregarUsuario(nuevoUsuario);
            listaUsuarios.serializarLista("usuarios.ser");
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        loginUsuario newframe = new loginUsuario();
        newframe.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_botonRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel etiquetaEmail;
    private javax.swing.JLabel etiquetaImagen;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPassword;
    private javax.swing.JLabel etiquetaRegistrarse;
    private javax.swing.JLabel etiquetaUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JPasswordField textoPassword;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
