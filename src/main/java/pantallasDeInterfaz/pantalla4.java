/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pantallasDeInterfaz;

import com.mycompany.gestor_actividades.Actividad;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import listaUsuarios.Usuario;

/**
 *
 * @author PC
 */
public class pantalla4 extends javax.swing.JPanel {
    private Usuario usuario;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form pantallaInicio
     */
    public pantalla4(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        iniciarEstilos();
        cargarDatos();
        actualizarTablaDatos();
        configurarTabla();
        configurarBuscador();

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
        etiqueta2 = new javax.swing.JLabel();
        Buscador = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaDatos = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }

        };
        tablaDatos.setBackground(new java.awt.Color(241, 254, 255));
        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Actividad", "Fecha", "Prioridad", "Tiempo Estimado", "Detalles"
            }
        ));
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        texto1.setText("Lista de actividades - Recomendación");

        etiqueta2.setText("Información");

        Buscador.setText("Buscar");
        Buscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorMouseClicked(evt);
            }
        });
        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(texto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto1)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
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
    private void cargarDatos() {
        usuario.cargarArbolActividades();
    }


    private void actualizarTablaDatos() {
       List<Actividad> actividades = usuario.getArbolActividades().obtenerActividadesRecomendadas();
       DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();
       model.setRowCount(0);

       SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES")); // Formato de fecha en español
       Date now = new Date(); // Fecha actual

       // Si hay actividades disponibles
       if (!actividades.isEmpty()) {
           Actividad tareaMasCercana = actividades.get(0); // Obtener la primera actividad (la más cercana por fecha límite)
           Date fechaLimiteProximaTarea = tareaMasCercana.getFechaLimite();

           // Calcular tiempo restante en días para la próxima tarea
           long diffProximaTarea = (fechaLimiteProximaTarea.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
           String tiempoRestanteProximaTarea = diffProximaTarea + " días";

           // Calcular tiempo restante total en días para todas las tareas
           long diffTotalTareas = 0;
           for (Actividad actividad : actividades) {
               Date fechaLimite = actividad.getFechaLimite();
               long diff = (fechaLimite.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
               diffTotalTareas += diff;
           }
           String tiempoRestanteTotal = diffTotalTareas + " días";

           // Calcular tiempo estimado total en minutos para todas las tareas
           int tiempoTotalEstimado = 0;
           for (Actividad actividad : actividades) {
               tiempoTotalEstimado += actividad.getTiempoEstimado();
           }

           // Calcular tiempo de descanso estimado en minutos
           int tiempoDescanso = tiempoTotalEstimado / 10; // Por ejemplo, 10% del tiempo total estimado como descanso

           // Agregar filas con datos de las actividades recomendadas en la tabla
           for (Actividad actividad : actividades) {
               String fechaFormateada = sdf.format(actividad.getFechaLimite());
               Object[] rowData = {
                   actividad.getNombre(),
                   fechaFormateada,
                   actividad.getPrioridad(),
                   actividad.getTiempoEstimado() + " minutos",
                   "Ingresar"
               };
               model.addRow(rowData);
           }

           // Actualizar etiqueta con los tiempos calculados
           etiqueta2.setText("<html>Cuenta con " + tiempoRestanteProximaTarea + " para terminar su próxima tarea y " + " un tiempo estimado total de " + tiempoTotalEstimado + " minutos. Puede descansar " + tiempoDescanso + " minutos. No es necesario acelerar sus actividades para terminar a tiempo.</html>");
       } else {
           // Si no hay actividades disponibles, limpiar la tabla y la etiqueta
           model.setRowCount(0); // Limpiar la tabla
           etiqueta2.setText("Tiempo restante:");
       }
   }


    private void configurarTabla() {
        tablaDatos.setDefaultEditor(Object.class, null);
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        tablaDatos.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaDatos.getColumnCount(); i++) {
            tablaDatos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        tablaDatos.getTableHeader().setDefaultRenderer(new HeaderRenderer());
    }




    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        int columnaBotonDetalles = 4;
        int fila = tablaDatos.rowAtPoint(evt.getPoint());


        if (fila != -1) {
            String nombreActividad = (String) tablaDatos.getValueAt(fila, 0);
            if (tablaDatos.columnAtPoint(evt.getPoint()) == columnaBotonDetalles) {
                Actividad actividad = usuario.getArbolActividades().obtenerActividadesRecomendadas().get(fila);
                List<Actividad> subactividades = actividad.getSubActividades();            
                // Construyes el mensaje con las subactividades
                StringBuilder mensaje = new StringBuilder();
                mensaje.append("Actividad ").append(actividad.getNombre()).append(":\n");
                mensaje.append("\nNombre: ").append(actividad.getNombre());
                mensaje.append("\nDescripción: ").append(actividad.getDescripcion());
                mensaje.append("\nFecha Límite: ").append(dateFormat.format(actividad.getFechaLimite()));
                mensaje.append("\nTiempo Estimado: ").append(actividad.getTiempoEstimado()).append(" minutos");
                mensaje.append("\nPrioridad: ").append(actividad.getPrioridad());
                mensaje.append("\n--------------------------\n");

                mensaje.append("Subactividades").append(":\n");

                for (Actividad subactividad : subactividades) {
                    mensaje.append("\nNombre: ").append(subactividad.getNombre());
                    mensaje.append("\nDescripción: ").append(subactividad.getDescripcion());
        //          mensaje.append("\nFecha Límite: ").append(dateFormat.format(subactividad.getFechaLimite()));
                    mensaje.append("\nTiempo Estimado: ").append(subactividad.getTiempoEstimado()).append(" minutos");
        //          mensaje.append("\nPrioridad: ").append(subactividad.getPrioridad());
                    mensaje.append("\n--------------------------\n");
                }

                // Muestra el mensaje en un JOptionPane
                JOptionPane.showMessageDialog(null, mensaje.toString(), "Subactividades de " + actividad.getNombre(), JOptionPane.INFORMATION_MESSAGE); 
            }
        }

    }//GEN-LAST:event_tablaDatosMouseClicked

    private void BuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorMouseClicked
        Buscador.setText("");
    }//GEN-LAST:event_BuscadorMouseClicked

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        Buscador.setText("");
    }//GEN-LAST:event_BuscadorActionPerformed
    private void iniciarEstilos(){
        //Coleres de textos
        texto1.putClientProperty( "FlatLaf.styleClass", "h1" );
        texto1.setForeground(new Color(51, 153, 255));
  
        etiqueta2.putClientProperty( "FlatLaf.styleClass", "h3" );
        etiqueta2.setForeground(new Color(51, 153, 255));
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

    private void configurarBuscador() {
        Buscador.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                actualizarTablaPorBusqueda();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                actualizarTablaPorBusqueda();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                actualizarTablaPorBusqueda();
            }
        });
    }

    private void actualizarTablaPorBusqueda() {
        String busqueda = Buscador.getText().trim(); // Obtener el texto del buscador y quitar espacios en blanco


        if ("Buscar".equalsIgnoreCase(busqueda)) {
            busqueda = null;
        }

        // Actualizar la tabla con el texto del buscador como filtro
        actualizarTablaDatos( busqueda);
    }

    private void actualizarTablaDatos( String busqueda) {
        List<Actividad> actividades = usuario.getArbolActividades().obtenerActividadesRecomendadas();
        DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();
        model.setRowCount(0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES")); // Formato de fecha en español

        for (Actividad actividad : actividades) {
            String fechaFormateada = sdf.format(actividad.getFechaLimite());
            String prioridad = String.valueOf(actividad.getPrioridad());

            // Verificar si coincide con el filtro de fecha, prioridad y búsqueda
    
            boolean coincideBusqueda = busqueda == null || actividad.getNombre().toLowerCase().contains(busqueda.toLowerCase());

            if ( coincideBusqueda) {
                Object[] rowData = {
                   actividad.getNombre(),
                   fechaFormateada,
                   actividad.getPrioridad(),
                   actividad.getTiempoEstimado() + " minutos",
                   "Ingresar"
                };
                model.addRow(rowData);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JLabel etiqueta2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JLabel texto1;
    // End of variables declaration//GEN-END:variables
}
