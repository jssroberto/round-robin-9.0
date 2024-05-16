package org.itson.disenosw.guis;

import control.ControlPedido;
import dtos.PedidoDTO;
import excepciones.BOException;
import excepciones.PersistenciaException;
import interfaces.IControlPedido;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author Roberto García
 */
public class PanelHistorial extends javax.swing.JPanel {

    private static final Logger logger = Logger.getLogger(PanelMenu.class.getName());

    FramePrincipal framePrincipal;
    private PedidoDTO pedidoDTO;
    //declarar etiqueta como pedidosdto.size dentro del metodo de crear historial y decrementar

    /**
     * Creates new form PanelHistorial
     */
    public PanelHistorial(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        this.pedidoDTO = new PedidoDTO();
        initComponents();
        try {
            crearHistorial();
        } catch (BOException | PersistenciaException ex) {
            framePrincipal.mostrarAviso(ex.getMessage(), "Aviso");
        }
        setFuentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenu = new javax.swing.JButton();
        btnCarrito = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        lblHistorialVacio = new javax.swing.JLabel();
        panelTop = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenu.setBorder(null);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 65, 65));

        btnCarrito.setBorder(null);
        btnCarrito.setContentAreaFilled(false);
        btnCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarritoActionPerformed(evt);
            }
        });
        add(btnCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 18, 50, 50));

        btnUsuario.setBorder(null);
        btnUsuario.setContentAreaFilled(false);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 18, 50, 50));

        btnHistorial.setBorder(null);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 18, 50, 50));

        lblHistorialVacio.setEnabled(false);
        add(lblHistorialVacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelTop.setOpaque(false);
        add(panelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 380, 547));

        btnRegresar.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 714, 40, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panelHistorial.png"))); // NOI18N
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        lblFondo.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarritoActionPerformed

        //        framePrincipal.setIdProducto(1l);
        framePrincipal.cambiarVistaCarrito();
    }//GEN-LAST:event_btnCarritoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        framePrincipal.cambiarPanelHistorial();
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        framePrincipal.cambiarVistaMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        framePrincipal.cambiarVistaMenu();
    }//GEN-LAST:event_btnMenuActionPerformed

    public void crearHistorial() throws BOException, PersistenciaException {

        IControlPedido controlPedido = new ControlPedido();
        List<PedidoDTO> pedidoDTOs = controlPedido.consultarPedidos(framePrincipal.getIdUsuario());

        if (pedidoDTOs == null) {
            Font sizedFont = cargarFuente("/fonts/futura/FuturaPTBook.otf", 48F);
            lblHistorialVacio.setFont(sizedFont);
            lblHistorialVacio.setText("¡HISTORIAL VACÍO!");
            lblHistorialVacio.setForeground(Color.BLACK);
            lblHistorialVacio.setEnabled(true);
            JPanel panelVacio = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 90));
            panelVacio.add(lblHistorialVacio);
            panelVacio.setOpaque(false);

            panelTop.add(panelVacio);
            return;
        }

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.setMaximumSize(new Dimension(380, 547));
        mainPanel.setSize(new Dimension(380, 547));

        GridBagConstraints c = new GridBagConstraints();

        //TODO no jala el insertar elemento de arriba a abajo, empiezan del centro
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;

        
        int posicionPedido = 0;
        String[] rutas;
        // Iterar sobre la lista de productos y crear los paneles correspondientes
        for (int i = pedidoDTOs.size() - 1; i >= 0; i--) {
            if (pedidoDTOs.get(i).getDetalleProductos().size() > 2) {
                rutas = new String[2];

            } else {
                rutas = new String[pedidoDTOs.get(i).getDetalleProductos().size()];

            }
            for (int j = 0; j < 2; j++) {
                if (pedidoDTOs.get(i).getDetalleProductos().size() == j) {
                    break;
                }
                rutas[j] = pedidoDTOs.get(i).getDetalleProductos().get(j).getDireccionImagen();
            }
            JPanel productoPanel = crearPanelPedido(
                    i + 1,
                    pedidoDTOs.get(i).getEtiquetaPedido(),
                    pedidoDTOs.get(i).getClaveRecoleccion(),
                    pedidoDTOs.get(i).getNumeroProductos(),
                    pedidoDTOs.get(i).getTotal(),
                    pedidoDTOs.get(i).getFecha(),
                    rutas);

            //poner objectidpedido
            String identificador = pedidoDTOs.get(i).getIdPedido();
            productoPanel.putClientProperty(identificador, productoPanel);
            // Añade un ActionListener al panel de producto
            productoPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Acción a realizar al hacer clic en el panel de producto
                    // Aquí puedes acceder al identificador del panel haciendo uso de la variable 'identificador'
                    logger.log(Level.INFO, "Clic en el panel de pedido: {0}", identificador);
                    framePrincipal.setIdPedido(identificador);
                    framePrincipal.cambiarPanelHistorialPedido();

                }
            });
            // Añade el panel del producto en la posición i * 2 (para dejar espacio para los separadores)
            c.gridx = 0;
            c.gridy = posicionPedido * 2;
            mainPanel.add(productoPanel, c);

            // Añade un separador después de cada producto, excepto el último
            if (posicionPedido < pedidoDTOs.size() - 1) {
                JPanel separatorPanel = createSeparatorPanel();
                c.gridx = 0;
                c.gridy = posicionPedido * 2 + 1;
                mainPanel.add(separatorPanel, c);
            }

            productoPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            posicionPedido++;

        }

        //TODO hacer el scrollPane un ScrollPaneWin11
        // Configurar el JScrollPane para desplazamiento vertical
        JScrollPane scrollPane = new JScrollPane(mainPanel);

        scrollPane.setPreferredSize(new Dimension(380, 547)); // Establece un tamaño predeterminado
        scrollPane.setMaximumSize(new Dimension(380, 547)); // Establece un tamaño máximo
        scrollPane.getViewport().setPreferredSize(new Dimension(380, 547)); // Establece un tamaño predeterminado para el viewport
        scrollPane.getViewport().setMaximumSize(new Dimension(380, 547)); // Establece un tamaño mínimo para el viewport
        scrollPane.getViewport().setSize(380, 547);

        scrollPane.setOpaque(false); // Hacer el JScrollPane transparente
        scrollPane.getViewport().setOpaque(false); // Hacer transparente el viewport del JScrollPane
        scrollPane.setBorder(null); // Eliminar el borde del JScrollPane
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Ajustar la velocidad del scroll vertical
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Ocultar la barra de desplazamiento horizontal

        JPanel cont = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        cont.add(scrollPane);
        cont.setOpaque(false);

        panelTop.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        panelTop.add(cont);

    }

    /**
     * Crea un panel que muestra la información de un producto, incluyendo
     * nombre, precio e imagen.
     *
     * @param nombre El nombre del producto a mostrar.
     * @param precio El precio del producto a mostrar.
     * @param rutaImagen La ruta de la imagen del producto.
     * @return El panel del producto creado.
     */
    private JPanel crearPanelPedido(int identificador, String numero, String claveRecoger, Integer numArticulos, Float total, LocalDate fecha, String[] rutaImagenes) {
        // Crear un nuevo panel para el producto con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // Hacer que el fondo del panel sea transparente

        // Configuración de GridBagConstraints para organizar los componentes dentro del panel
        GridBagConstraints c = new GridBagConstraints();

        String rutaFolder = "/productos/120x100/";
        String[] rutasResolucion = new String[rutaImagenes.length];
        for (int i = 0; i < rutaImagenes.length; i++) {
            StringBuilder rutaRelativa = new StringBuilder();
            rutaRelativa.append(rutaFolder);
            rutaRelativa.append(rutaImagenes[i]);
            rutasResolucion[i] = rutaRelativa.toString();
        }

        // Cargar la imagen del producto
        ImageIcon[] icons = new ImageIcon[rutasResolucion.length];
        JLabel[] imagenLabels = new JLabel[icons.length];
        for (int i = 0; i < rutasResolucion.length; i++) {
            icons[i] = new ImageIcon(PanelMenu.class.getResource(String.valueOf(rutasResolucion[i])));
            imagenLabels[i] = new JLabel(icons[i]);
            imagenLabels[i].setPreferredSize(new Dimension(120, 100));
            imagenLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
//            imagenLabels[i].setOpaque(true);
//            imagenLabels[i].setBackground(Color.YELLOW);

        }

        Font sizedFontMedium = cargarFuente("/fonts/futura/FuturaPTMedium.otf", 24F);
        Font sizedFontBook = cargarFuente("/fonts/futura/FuturaPTBook.otf", 24F);
        Font sizedFontDemi = cargarFuente("/fonts/futura/FuturaPTDemi.otf", 24F);

        // Configurar la etiqueta del nombre del producto
        JLabel identificadorLabel = new JLabel("Pedido #" + String.valueOf(identificador));
        identificadorLabel.setFont(sizedFontDemi);
        identificadorLabel.setForeground(Color.BLACK);
        identificadorLabel.setPreferredSize(new Dimension(125, 31));
        identificadorLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Label para el número de artículos
        JLabel numArticulosLabel = new JLabel(numArticulos.toString() + " artículo(s)");
        numArticulosLabel.setFont(sizedFontMedium);
        numArticulosLabel.setForeground(Color.BLACK);
        numArticulosLabel.setPreferredSize(new Dimension(125, 31));

        String totalFormateado = String.valueOf(total);
        if (totalFormateado.endsWith(".0")) {
            totalFormateado = totalFormateado.substring(0, totalFormateado.length() - 2);
        }
        // Configurar la etiqueta del precio
        JLabel precioLabel = new JLabel("$" + totalFormateado);
        precioLabel.setFont((sizedFontBook));
        precioLabel.setForeground(Color.BLACK);
        precioLabel.setPreferredSize(new Dimension(125, 31));
        precioLabel.setVerticalAlignment(SwingConstants.CENTER);
        precioLabel.setHorizontalAlignment(SwingConstants.LEFT);
//        precioLabel.setOpaque(true);
//        precioLabel.setBackground(Color.YELLOW);

        // Formatear fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fecha.format(formatter);

        //Label de fecha
        JLabel fechaLabel = new JLabel(fechaFormateada);
        fechaLabel.setFont(sizedFontMedium);
        fechaLabel.setForeground(Color.BLACK);
        fechaLabel.setPreferredSize(new Dimension(235, 31));
        fechaLabel.setVerticalAlignment(SwingConstants.CENTER);
        fechaLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //Label de número de pedido
        JLabel numeroLabel = new JLabel("P-" + numero.toUpperCase());
        numeroLabel.setFont(sizedFontDemi);
        numeroLabel.setForeground(Color.BLACK);
        numeroLabel.setPreferredSize(new Dimension(235, 31));
        numeroLabel.setVerticalAlignment(SwingConstants.CENTER);
        numeroLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //Label de clave para recoger pedido
        JLabel claveRecogerLabel = new JLabel(claveRecoger.toUpperCase());
        claveRecogerLabel.setFont(sizedFontDemi);
        claveRecogerLabel.setForeground(Color.BLACK);
        claveRecogerLabel.setPreferredSize(new Dimension(235, 31));
        claveRecogerLabel.setVerticalAlignment(SwingConstants.CENTER);
        claveRecogerLabel.setHorizontalAlignment(SwingConstants.RIGHT);

//        // imageIcon para el bullet point
//        ImageIcon bulletPoint = new ImageIcon(PanelMenu.class.getResource("/bullet.png"));
//        JLabel bulletPointLabel = new JLabel(bulletPoint);
//        bulletPointLabel.setFont(sizedFontDemi);
//        bulletPointLabel.setForeground(Color.BLACK);
//        bulletPointLabel.setPreferredSize(new Dimension(20, 31));
//        bulletPointLabel.setVerticalAlignment(SwingConstants.CENTER);
//        bulletPointLabel.setHorizontalAlignment(SwingConstants.LEFT);
//        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(identificadorLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(numArticulosLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(precioLabel, c);

        //falta el bullet point aqui
        c.gridx = 1;
        c.gridy = 2;
        panel.add(fechaLabel, c);
//
//        c.gridx = 2;
//        c.gridy = 2;
//        panel.add(fechaLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(numeroLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(claveRecogerLabel, c);

        for (int i = 0; i < imagenLabels.length; i++) {
            c.gridx = i;
            c.gridy = 3;
            panel.add(imagenLabels[i], c);
        }

        return panel; // Devuelve el panel del producto creado
    }

    /**
     * Crea un panel separador con una imagen personalizada. El panel separador
     * consiste en una imagen centrada verticalmente dentro de un panel que
     * actúa como un separador visual entre componentes.
     *
     * @return El panel separador creado.
     */
    private static JPanel createSeparatorPanel() {
        // Crear un nuevo panel para el separador
        JPanel panel = new JPanel();
        panel.setOpaque(false); // Hace que el panel sea transparente
        panel.setPreferredSize(new Dimension(350, 11)); // Establece el tamaño preferido del panel

        // Cargar la imagen del separador
        ImageIcon icon = new ImageIcon(PanelMenu.class.getResource("/separador.png"));

        // Crear una etiqueta para mostrar la imagen del separador
        JLabel imagen = new JLabel(icon);

        // Configurar el layout del panel como BoxLayout vertical
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Añadir pegamento vertical para centrar la imagen verticalmente
        panel.add(Box.createVerticalGlue());

        // Añadir la imagen al panel
        panel.add(imagen);

        // Añadir más pegamento vertical para centrar la imagen verticalmente
        panel.add(Box.createVerticalGlue());

        return panel; // Devuelve el panel separador creado
    }

    /**
     * Carga una fuente desde un archivo de fuente TrueType (TTF) y la devuelve
     * con el tamaño especificado.
     *
     * @param rutaFuente La ruta del archivo de fuente TrueType (TTF).
     * @param size El tamaño de la fuente a cargar.
     * @return La fuente cargada con el tamaño especificado.
     * @throws IllegalArgumentException Si el archivo de fuente no se encuentra
     * en la ruta especificada.
     */
    private static Font cargarFuente(String rutaFuente, float size) {
        InputStream is = PanelMenu.class.getResourceAsStream(rutaFuente);
        if (is == null) {
            throw new IllegalArgumentException("Archivo no encontrado: " + rutaFuente);
        }

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(size);
        } catch (FontFormatException | IOException ex) {
            logger.log(Level.SEVERE, "Error al cargar la fuente: " + rutaFuente, ex);
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error al cerrar InputStream", ex);
            }
        }
    }

    public void setFuentes() {
        Font sizedFontHeavy12 = cargarFuente("/fonts/futura/FuturaPTHeavy.otf", 12F);
//        lblCantidadCarrito.setFont(sizedFontHeavy12);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblHistorialVacio;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables
}
