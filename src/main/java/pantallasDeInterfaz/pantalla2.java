/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pantallasDeInterfaz;

import com.mycompany.gestor_actividades.GestionDeActividades;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author PC
 */
public class pantalla2 extends javax.swing.JPanel {
    private GestionDeActividades gestorActividades;

    /**
     * Creates new form pantallaInicio
     */
    public pantalla2() {
        gestorActividades = new GestionDeActividades();
        initComponents();
        iniciarEstilos();
        actualizarTablaDatos();
        configurarTabla();


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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        texto1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaDatos = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }

        };
        tablaDatos.setBackground(new java.awt.Color(241, 254, 255));
        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Descripcion", "Prioridad", "Tiempo estimado", "Eliminar", "Modificar"
            }
        ));
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        texto1.setText("Lista de actividades - General");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(texto1)
                .addContainerGap(605, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(texto1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

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
    public void actualizarTablaDatos() {
        String[][] datosActividades = gestorActividades.obtenerDatosActividades();
        DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();
        model.setRowCount(0);

        for (String[] datosActividad : datosActividades) {
            Object[] rowData = {datosActividad[0], datosActividad[1], datosActividad[2],datosActividad[3],"Eliminar", "Modificar"};
            model.addRow(rowData);
        }
    }


        
     // Configuracion para que la tabla de proyectos no sea editable y desactiva la reorganización de columnas.


    private void configurarTabla() {
        tablaDatos.setDefaultEditor(Object.class, null);
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        tablaDatos.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        tablaDatos.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());

        // Alineación centrada para las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaDatos.getColumnCount(); i++) {
            tablaDatos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Alineación centrada para el encabezado
        tablaDatos.getTableHeader().setDefaultRenderer(new HeaderRenderer());
    }



    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        int columnaBotonEliminar = 4; // La columna del botón "Eliminar"
        int columnaBotonModificar = 5; // La columna del botón "Modificar"

        int fila = tablaDatos.rowAtPoint(evt.getPoint());
        if (fila != -1) {
            String nombreActividad = (String) tablaDatos.getValueAt(fila, 0);
            if (tablaDatos.columnAtPoint(evt.getPoint()) == columnaBotonEliminar) {
                boolean eliminado = gestorActividades.eliminarActividad(nombreActividad);
                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Actividad eliminada exitosamente.");
                    actualizarTablaDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la actividad.");
                }
            } else if (tablaDatos.columnAtPoint(evt.getPoint()) == columnaBotonModificar) {
                String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción para " + nombreActividad);
                if (nuevaDescripcion != null && !nuevaDescripcion.trim().isEmpty()) {
                    gestorActividades.modificarActividad(nombreActividad, nuevaDescripcion);
                    actualizarTablaDatos();
                }
            }
        }

   

    }//GEN-LAST:event_tablaDatosMouseClicked
    private void iniciarEstilos(){
        //Coleres de textos
        texto1.putClientProperty( "FlatLaf.styleClass", "h1" );
        texto1.setForeground(new Color(51, 153, 255));

    }
    private static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
    private static class HeaderRenderer extends DefaultTableCellRenderer {
        public HeaderRenderer() {
            setOpaque(true);
            setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBackground(new Color(51, 153, 255)); // Cambia el color de fondo al color RGB (51, 153, 255)
            setForeground(Color.WHITE); // Cambia el color del texto a blanco
            return this;
        }
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JLabel texto1;
    // End of variables declaration//GEN-END:variables
}