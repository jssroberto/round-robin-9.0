package org.itson.disenosw.guis;

import Metodos.BusquedaDinamica;
import control.ControlProductos;
import dominio.ProductoCafeteria;
import dtos.ProductoCafeteriaDTO;
import excepciones.CafeteriaException;
import interfaces.IBusqueda;
import interfaces.IControlProductos;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Roberto García
 */
public final class PanelBuscar extends javax.swing.JPanel {

    private static final Logger logger = Logger.getLogger(PanelBuscar.class.getName());

    private FramePrincipal framePrincipal;
    private List<ProductoCafeteriaDTO> productos;

    /**
     * Constructor de la clase PanelBuscar.
     *
     * @param framePrincipal La framePrincipal principal de la aplicación.
     */
    public PanelBuscar(FramePrincipal framePrincipal) throws CafeteriaException {
        this.framePrincipal = framePrincipal;
        initComponents();
        productos = new ArrayList<>();
        inicializarProductos();
        inicializarMenu();
        Buscador.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    buscarProductosSimilares(Buscador.getText());
                } catch (CafeteriaException ex) {
                    System.out.println("Error en la búsqueda: "); // Imprime el mensaje de error en la consola
                    framePrincipal.mostrarAviso("Vuelva a intentarlo", "Aviso");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    buscarProductosSimilares(Buscador.getText());
                } catch (CafeteriaException ex) {
                    System.out.println("Error en la búsqueda: "); // Imprime el mensaje de error en la consola
                    framePrincipal.mostrarAviso("Vuelva a intentarlo", "Aviso");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    buscarProductosSimilares(Buscador.getText());
                } catch (CafeteriaException ex) {
                    System.out.println("Error en la búsqueda: "); // Imprime el mensaje de error en la consola
                    framePrincipal.mostrarAviso("Vuelva a intentarlo", "Aviso");
                }
            }
        });
    }

    public void inicializarMenu() {
        JMenuItem ordenarAZ = new JMenuItem("Ordenar desde A");
        JMenuItem ordenarZA = new JMenuItem("Ordenar desde Z");
        JMenuItem ordenarPrecio = new JMenuItem("Ordenar por Precio");

        ppMenu.add(ordenarAZ);
        ppMenu.addSeparator();
        ppMenu.add(ordenarZA);
        ppMenu.addSeparator();
        ppMenu.add(ordenarPrecio);

        btnOrdenar.setComponentPopupMenu(ppMenu);

        ordenarAZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<ProductoCafeteriaDTO> productosFiltrados = new ArrayList<>(productos);

                    IBusqueda busqueda = new BusquedaDinamica();
                    List<ProductoCafeteriaDTO> productosOrdenados;
                    productosOrdenados = busqueda.ordenarProductosFiltradosAZ(productosFiltrados);

                    panelTop.removeAll();
                    panelTop.revalidate();
                    panelTop.repaint();

                    productos.clear();
                    productos.addAll(productosOrdenados);
                    try {
                        crearMenu();
                    } catch (CafeteriaException ex) {
                        Logger.getLogger(PanelBuscar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (CafeteriaException ex) {
                    Logger.getLogger(PanelBuscar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ordenarZA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<ProductoCafeteriaDTO> productosFiltrados = new ArrayList<>(productos);

                    IBusqueda busqueda = new BusquedaDinamica();
                    List<ProductoCafeteriaDTO> productosOrdenados;
                    productosOrdenados = busqueda.ordenarProductosFiltradosZA(productosFiltrados);

                    panelTop.removeAll();
                    panelTop.revalidate();
                    panelTop.repaint();

                    productos.clear();
                    productos.addAll(productosOrdenados);
                    try {
                        crearMenu();
                    } catch (CafeteriaException ex) {
                        Logger.getLogger("error");
                    }
                } catch (CafeteriaException ex) {
                    Logger.getLogger(PanelBuscar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ordenarPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<ProductoCafeteriaDTO> productosFiltrados = new ArrayList<>(productos);

                    IBusqueda busqueda = new BusquedaDinamica();
                    List<ProductoCafeteriaDTO> productosOrdenados;
                    productosOrdenados = busqueda.ordenarProductosFiltradosPorPrecio(productosFiltrados);

                    panelTop.removeAll();
                    panelTop.revalidate();
                    panelTop.repaint();

                    productos.clear();
                    productos.addAll(productosOrdenados);
                    try {
                        crearMenu();
                    } catch (CafeteriaException ex) {
                        Logger.getLogger("error");
                    }
                } catch (CafeteriaException ex) {
                    Logger.getLogger(PanelBuscar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public ProductoCafeteriaDTO convertirDAOenDTO(ProductoCafeteria productoCafeteria) {
        ProductoCafeteriaDTO productoCafeteriaDTO = new ProductoCafeteriaDTO();

        productoCafeteriaDTO.setPrecio(productoCafeteria.getPrecio());
        productoCafeteriaDTO.setNombre(productoCafeteria.getNombre());
        productoCafeteriaDTO.setDescripcion(productoCafeteria.getDescripcion());
        productoCafeteriaDTO.setCantidadDisponible(productoCafeteria.getCantidadDisponible());
        productoCafeteriaDTO.setDireccionImagen(productoCafeteria.getDireccionImagen());
        productoCafeteriaDTO.setId(productoCafeteria.getId());
        productoCafeteriaDTO.setIdProductoCafeteria(productoCafeteria.getCodigo());
        return productoCafeteriaDTO;
    }

    private void buscarProductosSimilares(String textoBusqueda) throws CafeteriaException {
        try {
            // Obtener todos los productos al inicio
            IControlProductos consultarProductoBO = new ControlProductos();
            List<ProductoCafeteria> productosCafeteria = consultarProductoBO.obtenerTodosLosProductos();

            // Crear una lista para almacenar los productos filtrados
            List<ProductoCafeteriaDTO> productosFiltrados = new ArrayList<>();

            // Verificar si el texto de búsqueda no está vacío
            if (!textoBusqueda.isEmpty()) {
                // Aplicar filtro de búsqueda
                IBusqueda busqueda = new BusquedaDinamica();
                try {
                    productosFiltrados = busqueda.consultarProductos(textoBusqueda);
                } catch (CafeteriaException ex) {
                    Logger.getLogger(PanelBuscar.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // Si el texto de búsqueda está vacío, mostrar todos los productos
                for (ProductoCafeteria producto : productosCafeteria) {
                    productosFiltrados.add(convertirDAOenDTO(producto));
                }
            }
            // Limpiar el panel antes de agregar nuevos elementos
            panelTop.removeAll();
            panelTop.revalidate();
            panelTop.repaint();

            // Volver a crear el menú con los productos encontrados
            productos.clear();
            productos.addAll(productosFiltrados);
            crearMenu();

        } catch (CafeteriaException e) {
            throw new CafeteriaException("Error en la busqueda");
        }

    }

    public void inicializarProductos() throws CafeteriaException {
        try {
            // Obtener todos los productos al inicio
            IControlProductos consultarProductoBO = new ControlProductos();
            List<ProductoCafeteria> productosCafeteria = consultarProductoBO.obtenerTodosLosProductos();
            for (ProductoCafeteria producto : productosCafeteria) {
                productos.add(convertirDAOenDTO(producto));
            }

            crearMenu();
        } catch (CafeteriaException ex) {
            throw new CafeteriaException("Error en la busqueda");
        }
    }

    public void crearMenu() throws CafeteriaException {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.setMaximumSize(new Dimension(370, 550));// Elimina esta línea
        mainPanel.setSize(new Dimension(370, 550));

        GridBagConstraints c = new GridBagConstraints();

        //TODO no jala el insertar elemento de arriba a abajo, empiezan del centro
        c.anchor = GridBagConstraints.NORTH;

        // Iterar sobre la lista de productos y crear los paneles correspondientes
        for (ProductoCafeteriaDTO producto : productos) {
            JPanel productoPanel = createProductoPanel(producto.getNombre(), producto.getPrecio(), producto.getDireccionImagen());

            String identificador = producto.getIdProductoCafeteria();
            productoPanel.putClientProperty(identificador, productoPanel);
            productoPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        // Acción a realizar al hacer clic en el panel de producto
                        // Aquí puedes acceder al identificador del panel haciendo uso de la variable 'identificador'

                        framePrincipal.setCodigoProducto(identificador);
                        System.out.println(framePrincipal.getCodigoProducto());
                        framePrincipal.cambiarVistaProducto();
                    } catch (Exception ex) {
                        framePrincipal.mostrarAviso(ex.getMessage(), "Aviso");
                    }

                }
            });
            // Añade un ActionListener al panel de producto
            // Añade el panel del producto en la posición i * 2 (para dejar espacio para los separadores)
            c.gridx = 0;
            c.gridy = productos.indexOf(producto) * 2;
            mainPanel.add(productoPanel, c);

            // Añade un separador después de cada producto, excepto el último
            if (productos.indexOf(producto) < productos.size() - 1) {
                JPanel separatorPanel = createSeparatorPanel();
                c.gridx = 0;
                c.gridy = productos.indexOf(producto) * 2 + 1;
                mainPanel.add(separatorPanel, c);
            }

            productoPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        //TODO hacer el scrollPane un ScrollPaneWin11
        // Configurar el JScrollPane para desplazamiento vertical
        JScrollPane scrollPane = new JScrollPane(mainPanel);

        scrollPane.setPreferredSize(new Dimension(370, 550)); // Establece un tamaño predeterminado
        scrollPane.setMaximumSize(new Dimension(370, 550)); // Establece un tamaño máximo
        scrollPane.getViewport().setPreferredSize(new Dimension(370, 550)); // Establece un tamaño predeterminado para el viewport
        scrollPane.getViewport().setMaximumSize(new Dimension(370, 550)); // Establece un tamaño mínimo para el viewport
        scrollPane.getViewport().setSize(370, 550);

        scrollPane.setOpaque(false); // Hacer el JScrollPane transparente
        scrollPane.getViewport().setOpaque(false); // Hacer transparente el viewport del JScrollPane
        scrollPane.setBorder(null); // Eliminar el borde del JScrollPane
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Ajustar la velocidad del scroll vertical
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Ocultar la barra de desplazamiento horizontal

        JPanel cont = new JPanel();
        cont.add(scrollPane);
        cont.setOpaque(false);

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
    private JPanel createProductoPanel(String nombre, Float precio, String rutaImagen) {
        // Crear un nuevo panel para el producto con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // Hacer que el fondo del panel sea transparente

        // Configuración de GridBagConstraints para organizar los componentes dentro del panel
        GridBagConstraints c = new GridBagConstraints();

        String rutaFolder = "/productos/120x100/";
        StringBuilder rutaRelativa = new StringBuilder();
        rutaRelativa.append(rutaFolder);
        rutaRelativa.append(rutaImagen);

        // Cargar la imagen del producto
        ImageIcon icon = new ImageIcon(PanelMenu.class.getResource(String.valueOf(rutaRelativa)));
        JLabel imagenLabel = new JLabel(icon);

        Font sizedFontMedium = cargarFuente("/fonts/futura/FuturaPTMedium.otf", 24F);
        Font sizedFontBook = cargarFuente("/fonts/futura/FuturaPTBook.otf", 24F);

        // Configurar la etiqueta del nombre del producto
        JLabel nombreLabel = new JLabel(nombre);
        nombreLabel.setFont(sizedFontMedium);
        nombreLabel.setForeground(Color.BLACK);
        nombreLabel.setPreferredSize(new Dimension(250, 31));
        nombreLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        String precioFormateado = String.valueOf(precio);
        if (precioFormateado.endsWith(".0")) {
            precioFormateado = precioFormateado.substring(0, precioFormateado.length() - 2);
        }
        // Configurar la etiqueta del precio
        JLabel precioLabel = new JLabel("$" + precioFormateado);
        precioLabel.setFont((sizedFontBook));
        precioLabel.setForeground(Color.BLACK);
        precioLabel.setPreferredSize(new Dimension(110, 31));
        precioLabel.setVerticalAlignment(SwingConstants.TOP);

        // Añadir la imagen a la parte derecha del panel
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        panel.add(imagenLabel, c);

        // Añadir la etiqueta del nombre del producto en la primera fila y primera columna
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
//        c.anchor = GridBagConstraints.CENTER; // Añadir esta línea para centrar horizontalmente
        panel.add(nombreLabel, c);

        // Añadir la etiqueta del precio en la segunda fila y primera columna
        c.gridx = 0;
        c.gridy = 1;
        panel.add(precioLabel, c);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppMenu = new javax.swing.JPopupMenu();
        btnCarrito = new javax.swing.JButton();
        btnOrdenar = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        Buscador = new javax.swing.JTextField();
        panelTop = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();

        ppMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ppMenuMouseClicked(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(400, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCarrito.setBorder(null);
        btnCarrito.setContentAreaFilled(false);
        btnCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarritoActionPerformed(evt);
            }
        });
        add(btnCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 15, 50, 50));

        btnOrdenar.setBorder(null);
        btnOrdenar.setContentAreaFilled(false);
        btnOrdenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 60, 60));

        btnUsuario.setBorder(null);
        btnUsuario.setContentAreaFilled(false);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 15, 50, 50));

        Buscador.setBackground(new java.awt.Color(250, 250, 250));
        Buscador.setBorder(null);
        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });
        Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscadorKeyPressed(evt);
            }
        });
        add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 123, 276, 31));

        panelTop.setOpaque(false);
        add(panelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 380, 530));

        btnRegresar.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 702, 50, 50));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pa.png"))); // NOI18N
        add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarritoActionPerformed

        framePrincipal.cambiarVistaCarrito();
    }//GEN-LAST:event_btnCarritoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        framePrincipal.cambiarVistaMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void BuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyPressed

    }//GEN-LAST:event_BuscadorKeyPressed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void ppMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ppMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ppMenuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPopupMenu ppMenu;
    // End of variables declaration//GEN-END:variables

}
