/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pantallasDeInterfaz;


import com.mycompany.gestor_actividades.Actividad;
import com.mycompany.gestor_actividades.ArbolAVL;
import com.mycompany.gestor_actividades.NodoAVL;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import listaUsuarios.Usuario;

/**
 *
 * @author tintaya
 */
public class pantalla5 extends javax.swing.JPanel {
    private ArbolAVL arbol;
    private JTree tree;

    public pantalla5(Usuario usuario) {
        this.arbol = usuario.getArbolActividades();
        initComponents();
         // Método para inicializar y mostrar el árbol
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Renderizado suavizado para líneas y formas
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (arbol != null && arbol.getRaiz() != null) {
            // Calcular la posición inicial para dibujar el árbol
            int startX = getWidth() / 2;
            int startY = 30;

            // Dibujar el árbol AVL
            drawAVLTree(g2d, arbol.getRaiz(), startX, startY, getWidth() / 4, 60);
        }
    }

    private void drawAVLTree(Graphics2D g2d, NodoAVL nodo, int x, int y, int xOffset, int yOffset) {
        if (nodo != null) {
            // Dibujar el nodo actual
            g2d.drawOval(x - 15, y - 15, 30, 30);
  //          g2d.drawString(String.valueOf(nodo.actividad.getPrioridad()), x - 10, y);
            g2d.drawString(nodo.actividad.getNombre(), x - 10, y);
            // Dibujar la conexión con el hijo izquierdo si existe
            if (nodo.izquierda != null) {
                int childX = x - xOffset;
                int childY = y + yOffset;
                g2d.drawLine(x, y, childX, childY); 
                drawAVLTree(g2d, nodo.izquierda, childX, childY, xOffset / 2, yOffset);
            }

            // Dibujar la conexión con el hijo derecho si existe
            if (nodo.derecha != null) {
                int childX = x + xOffset;
                int childY = y + yOffset;
                g2d.drawLine(x, y, childX, childY);
                drawAVLTree(g2d, nodo.derecha, childX, childY, xOffset / 2, yOffset);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
