/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pantallasDeInterfaz;

import com.mycompany.gestor_actividades.Actividad;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JList;
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
public class pantalla2 extends javax.swing.JPanel {
    private Usuario usuario;

    /**
     * Creates new form pantallaInicio
     */
    public pantalla2(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        iniciarEstilos();
        cargarDatos();
        llenarComboBoxFechas();
        llenarComboBoxPrioridad();// Llenar el combo box con las fechas de las actividades
        actualizarTablaDatos(null,null); // Cargar todas las actividades al inicio
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
        etiquetaImagen = new javax.swing.JLabel();
        etiqueta1 = new javax.swing.JLabel();
        etiqueta2 = new javax.swing.JLabel();
        fechas = new javax.swing.JComboBox<>();
        Prioridad = new javax.swing.JComboBox<>();
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

            },
            new String [] {
                "Actividad", "Descripción", "Fecha limite", "Tiempo estimado", "Prioridad", "Eliminar", "Modificar"
            }
        ));
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        texto1.setText("Lista de actividades - General");

        etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/notas.png"))); // NOI18N

        etiqueta1.setText("Se ordena en base a :  ");

        etiqueta2.setText("Fecha, prioridad, tiempo estimado y si todo lo anterior choca por decisión del usuario");

        fechas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fechas" }));
        fechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechasActionPerformed(evt);
            }
        });

        Prioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridad" }));
        Prioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrioridadActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(etiquetaImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiqueta1)
                            .addComponent(etiqueta2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(fechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(Prioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(texto1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(texto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Prioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(etiquetaImagen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(etiqueta1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiqueta2)))
                .addContainerGap(80, Short.MAX_VALUE))
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

    private void PrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrioridadActionPerformed
        String fechaSeleccionada = (String) fechas.getSelectedItem();
        String prioridadSeleccionada = (String) Prioridad.getSelectedItem();
        actualizarTablaDatos(fechaSeleccionada, prioridadSeleccionada);
    }//GEN-LAST:event_PrioridadActionPerformed

    private void fechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechasActionPerformed
        String fechaSeleccionada = (String) fechas.getSelectedItem();
        String prioridadSeleccionada = (String) Prioridad.getSelectedItem();
        actualizarTablaDatos(fechaSeleccionada, prioridadSeleccionada);
    }//GEN-LAST:event_fechasActionPerformed

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        int columnaBotonEliminar = 5;
        int columnaBotonModificar = 6;

        int fila = tablaDatos.rowAtPoint(evt.getPoint());
        if (fila != -1) {
            String nombreActividad = (String) tablaDatos.getValueAt(fila, 0);
            if (tablaDatos.columnAtPoint(evt.getPoint()) == columnaBotonEliminar) {
                boolean eliminado = usuario.getArbolActividades().eliminar(nombreActividad);
                if (eliminado) {
                    usuario.guardarArbolActividades();  // Guarda el árbol después de eliminar
                    JOptionPane.showMessageDialog(null, "Actividad eliminada exitosamente.");
                    actualizarTablaDatos(null,null);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la actividad.");
                }
            } else if (tablaDatos.columnAtPoint(evt.getPoint()) == columnaBotonModificar) {
                String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción para " + nombreActividad);
                if (nuevaDescripcion != null && !nuevaDescripcion.trim().isEmpty()) {
                    usuario.getArbolActividades().modificar(nombreActividad, nuevaDescripcion);
                    usuario.guardarArbolActividades();  // Guarda el árbol después de modificar
                    actualizarTablaDatos(null,null);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al modificar la actividad.");
                }
            }
        }
    }//GEN-LAST:event_tablaDatosMouseClicked

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        Buscador.setText(""); 
    }//GEN-LAST:event_BuscadorActionPerformed

    private void BuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorMouseClicked
        Buscador.setText("");
    }//GEN-LAST:event_BuscadorMouseClicked
    private void cargarDatos() {
        usuario.cargarArbolActividades();
    }


    private void actualizarTablaDatos(String fechaFiltro, String prioridadFiltro) {
    List<Actividad> actividades = usuario.getArbolActividades().obtenerActividades();
    DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();
    model.setRowCount(0);

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES")); // Formato de fecha en español

    for (Actividad actividad : actividades) {
        String fechaFormateada = sdf.format(actividad.getFechaLimite());
        String prioridad = String.valueOf(actividad.getPrioridad());

        // Verificar si coincide con el filtro de fecha y/o prioridad
        boolean coincideFecha = fechaFiltro == null || fechaFiltro.equals(fechaFormateada)||fechaFiltro.equals("Fechas");
        boolean coincidePrioridad = prioridadFiltro == null || prioridadFiltro.equals(prioridad)||prioridadFiltro.equals("Prioridad");

        if (coincideFecha && coincidePrioridad) {
            Object[] rowData = {
                actividad.getNombre(),
                actividad.getDescripcion(),
                fechaFormateada,
                actividad.getTiempoEstimado() + " minutos",
                prioridad,
                "Eliminar",
                "Modificar"
            };
            model.addRow(rowData);
        }
    }
}



    private void configurarTabla() {
        tablaDatos.setDefaultEditor(Object.class, null);
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        tablaDatos.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        tablaDatos.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaDatos.getColumnCount(); i++) {
            tablaDatos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        tablaDatos.getTableHeader().setDefaultRenderer(new HeaderRenderer());
    }



    private void iniciarEstilos(){
        //Coleres de textos
        texto1.putClientProperty( "FlatLaf.styleClass", "h1" );
        texto1.setForeground(new Color(51, 153, 255));
        etiqueta1.putClientProperty( "FlatLaf.styleClass", "h2" );
        etiqueta1.setForeground(new Color(51, 153, 255));
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
    private void llenarComboBoxFechas() {
        List<Actividad> actividades = usuario.getArbolActividades().obtenerActividades();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES")); // Formato de fecha en español
        fechas.removeAllItems(); // Limpiar items existentes

        // Añadir el primer ítem con texto "Fechas" y valor null
        fechas.addItem("Fechas");

        Set<String> fechasUnicas = new TreeSet<>(); // Usar TreeSet para mantener las fechas ordenadas automáticamente

        for (Actividad actividad : actividades) {
            String fechaFormateada = sdf.format(actividad.getFechaLimite());
            fechasUnicas.add(fechaFormateada); // Añadir fecha al set (solo se añaden las fechas únicas)
        }

        for (String fecha : fechasUnicas) {
            fechas.addItem(fecha); // Añadir fechas únicas al combo box
        }
    }

    private void llenarComboBoxPrioridad() {
        List<Actividad> actividades = usuario.getArbolActividades().obtenerActividades();
        Set<String> prioridadesUnicas = new HashSet<>();

        Prioridad.removeAllItems(); // Limpiar items existentes
        Prioridad.addItem("Prioridad"); // Añadir "Prioridad" como primer ítem

        for (Actividad actividad : actividades) {
            String prioridad = String.valueOf(actividad.getPrioridad());
            prioridadesUnicas.add(prioridad); // Añadir prioridad al set (solo únicas)
        }

        for (String prioridad : prioridadesUnicas) {
            Prioridad.addItem(prioridad); // Añadir prioridades únicas al combo box
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
        String fechaSeleccionada = (String) fechas.getSelectedItem();
        String prioridadSeleccionada = (String) Prioridad.getSelectedItem();

        if ("Buscar".equalsIgnoreCase(busqueda)) {
            busqueda = null;
        }

        // Actualizar la tabla con el texto del buscador como filtro
        actualizarTablaDatos(fechaSeleccionada, prioridadSeleccionada, busqueda);
    }

    private void actualizarTablaDatos(String fechaFiltro, String prioridadFiltro, String busqueda) {
        List<Actividad> actividades = usuario.getArbolActividades().obtenerActividades();
        DefaultTableModel model = (DefaultTableModel) tablaDatos.getModel();
        model.setRowCount(0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES")); // Formato de fecha en español

        for (Actividad actividad : actividades) {
            String fechaFormateada = sdf.format(actividad.getFechaLimite());
            String prioridad = String.valueOf(actividad.getPrioridad());

            // Verificar si coincide con el filtro de fecha, prioridad y búsqueda
            boolean coincideFecha = fechaFiltro == null || fechaFiltro.equals(fechaFormateada) || fechaFiltro.equals("Fechas");
            boolean coincidePrioridad = prioridadFiltro == null || prioridadFiltro.equals(prioridad) || prioridadFiltro.equals("Prioridad");
            boolean coincideBusqueda = busqueda == null || actividad.getNombre().toLowerCase().contains(busqueda.toLowerCase());

            if (coincideFecha && coincidePrioridad && coincideBusqueda) {
                Object[] rowData = {
                    actividad.getNombre(),
                    actividad.getDescripcion(),
                    fechaFormateada,
                    actividad.getTiempoEstimado() + " minutos",
                    prioridad,
                    "Eliminar",
                    "Modificar"
                };
                model.addRow(rowData);
            }
        }
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JComboBox<String> Prioridad;
    private javax.swing.JLabel etiqueta1;
    private javax.swing.JLabel etiqueta2;
    private javax.swing.JLabel etiquetaImagen;
    private javax.swing.JComboBox<String> fechas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JLabel texto1;
    // End of variables declaration//GEN-END:variables
}
