/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package listaUsuarios;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.Color;
import pantallasDeInterfaz.interfaz_Inicio;
import java.util.List;
import javax.swing.JOptionPane;
import pantallasDeInterfaz.pantalla1;

/**
 *
 * @author PC
 */
public class loginUsuario extends javax.swing.JFrame {
    private static ListaUsuarios listaUsuarios;

    /**
     * Creates new form loginUsuario
     */
    public loginUsuario() {
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
        etiquetaBienvenido = new javax.swing.JLabel();
        etiquetaUsuario = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        etiquetaPassword = new javax.swing.JLabel();
        textoPassword = new javax.swing.JPasswordField();
        etiquetaRegistro = new javax.swing.JLabel();
        etiquetaImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        etiquetaBienvenido.setText("Bienvenido");

        etiquetaUsuario.setText("Nombre de usuario");

        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        etiquetaPassword.setText("Password");

        textoPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPasswordActionPerformed(evt);
            }
        });

        etiquetaRegistro.setText("¿No tiene una cuenta?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(etiquetaBienvenido))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaRegistro)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(etiquetaPassword)
                                .addComponent(etiquetaUsuario)
                                .addComponent(textoUsuario)
                                .addComponent(botonIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addComponent(textoPassword)))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(etiquetaBienvenido)
                .addGap(31, 31, 31)
                .addComponent(etiquetaUsuario)
                .addGap(18, 18, 18)
                .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiquetaPassword)
                .addGap(18, 18, 18)
                .addComponent(textoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(botonIngresar)
                .addGap(18, 18, 18)
                .addComponent(etiquetaRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRegistrar)
                .addGap(55, 55, 55))
        );

        etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/perfil-del-usuario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(etiquetaImagen)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
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
        etiquetaBienvenido.putClientProperty( "FlatLaf.styleClass", "h1" );
        etiquetaBienvenido.setForeground(Color.white);
        etiquetaUsuario.putClientProperty( "FlatLaf.styleClass", "h2" );
        etiquetaUsuario.setForeground(Color.white);
        etiquetaPassword.putClientProperty( "FlatLaf.styleClass", "h2" );
        etiquetaPassword.setForeground(Color.white);
        etiquetaRegistro.putClientProperty( "FlatLaf.styleClass", "h3" );
        etiquetaRegistro.setForeground(Color.white);
        //Color de botones
        botonRegistrar.setForeground(Color.black);
        botonIngresar.setForeground(Color.black);


    }
    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        String nombreIngresado = textoUsuario.getText();
        Usuario usuarioEncontrado = listaUsuarios.buscarUsuario(nombreIngresado);

        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getPassword().equals(textoPassword.getText())) {
                interfaz_Inicio newframe = new interfaz_Inicio(usuarioEncontrado);
                newframe.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Password incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }




        // TODO add your handling code here:
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        crearUsuario newframe = new crearUsuario();
        newframe.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void textoPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(loginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel etiquetaBienvenido;
    private javax.swing.JLabel etiquetaImagen;
    private javax.swing.JLabel etiquetaPassword;
    private javax.swing.JLabel etiquetaRegistro;
    private javax.swing.JLabel etiquetaUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField textoPassword;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
