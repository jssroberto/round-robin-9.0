package org.itson.disenosw.guis;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import conexion.Conexion;
import dominio.ProductoCafeteria;
import excepciones.CafeteriaException;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * La clase Ventana representa la ventana principal de la aplicación bancaria.
 * Se encarga de gestionar la navegación entre diferentes vistas de la interfaz
 * de usuario, así como de interactuar con el usuario mediante ventanas
 * emergentes. También mantiene instancias de DTOs y una conexión a la base de
 * datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class FramePrincipal extends javax.swing.JFrame {

    private JPanel panelActual;
    private String codigoProducto;
    private String claveRecoleccion;
    private float totalCarrito = 0.0f;
    private String numID;
    private String idUsuario;
    private String idPedido;
    private int numPedido=0;
    private String idProducto2;
    private Integer puntosGenerados=0;
    

    public String getIdProducto2() {
        
        return idProducto2;
    }

    public void setIdProducto2(String idProducto2) {
        this.idProducto2 = idProducto2;
    }

    /**
     * Constructor de la clase Ventana.
     */
    public FramePrincipal() {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        List<Image> iconImages = new ArrayList<>();
        
        iconImages.add(new ImageIcon(FramePrincipal.class.getResource("/icons/icon16.png")).getImage());
        iconImages.add(new ImageIcon(FramePrincipal.class.getResource("/icons/icon32.png")).getImage());
        iconImages.add(new ImageIcon(FramePrincipal.class.getResource("/icons/icon64.png")).getImage());
        iconImages.add(new ImageIcon(FramePrincipal.class.getResource("/icons/icon128.png")).getImage());
        initComponents();
        
        this.setIconImages(iconImages);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cafetería Potros");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(400, 800));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Cafetería Potros");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Método para limpiar el contenido de la ventana. Si hay un panel
     * actualmente mostrado, lo elimina de la ventana.
     */
    public void limpiarFrame() {
        if (panelActual != null) {
            this.remove(panelActual);
            panelActual = null;
        }
    }

    /**
     * Método para cambiar a la vista de la ventana de Inicio. Este método
     * elimina el panel actual
     */
    public void cambiarVistaInicio() {
        limpiarFrame();
        PanelInicioSesion vistaInicioSesion = new PanelInicioSesion(this);
        ponerEnJFrame(vistaInicioSesion);
        panelActual = vistaInicioSesion;
    }

    /**
     * Método para cambiar a la vista de la ventana de Menu . Este método
     * elimina el panel actual
     */
    public void cambiarVistaMenu() {
        limpiarFrame();
        PanelMenu vistaMenu = new PanelMenu(this);
        ponerEnJFrame(vistaMenu);
        panelActual = vistaMenu;
    }
    
    public void cambiarPanelPagoExitoPuntos(Integer puntosGenerados, String clave){
        limpiarFrame();
        PanelPagoExitoPuntos panelBuscar = new PanelPagoExitoPuntos(this, puntosGenerados, clave);
        ponerEnJFrame(panelBuscar);
        panelActual = panelBuscar;
    }
    
    public void cambiarPanelPagoPuntosError(){
        limpiarFrame();
        PanelPagoPuntosError panelBuscar = new PanelPagoPuntosError(this);
        ponerEnJFrame(panelBuscar);
        panelActual = panelBuscar;
    }
    
    public void cambiarPanelPagoPuntosExito(){
        limpiarFrame();
        PanelPagoPuntosExito panelBuscar = new PanelPagoPuntosExito(this);
        ponerEnJFrame(panelBuscar);
        panelActual = panelBuscar;
    }

    /**
     * Método para cambiar a la vista de la ventana de Carrito . Este método
     * elimina el panel actual
     */
    public void cambiarVistaCarrito() {
        limpiarFrame();
        PanelCarrito vistaCarrito = new PanelCarrito(this);
        ponerEnJFrame(vistaCarrito);
        panelActual = vistaCarrito;
    }

    /**
     * Método para cambiar a la vista de la ventana de MetodoPago . Este método
     * elimina el panel actual
     */
    public void cambiarVistaMetodoPago() {
        limpiarFrame();
        PanelMetodoPago vistaMetodoPago = new PanelMetodoPago(this);
        ponerEnJFrame(vistaMetodoPago);
        panelActual = vistaMetodoPago;
    }

    /**
     * Método para cambiar a la vista de la ventana de Menu . Este método
     * elimina el panel actual
     */
    public void cambiarVistaProducto() {
        limpiarFrame();
        PanelProducto vistaProducto = new PanelProducto(this);
        ponerEnJFrame(vistaProducto);
        panelActual = vistaProducto;
    }

    /**
     * Método para cambiar a la vista de la ventana de Datos de Tarjeta . Este
     * método elimina el panel actual
     */
    public void cambiarVistaDatosTarjeta() {
        limpiarFrame();
        PanelDatosTarjeta vistaDatos = new PanelDatosTarjeta(this);
        ponerEnJFrame(vistaDatos);
        panelActual = vistaDatos;
    }

    public void cambiarPanelPagoExito() {
        limpiarFrame();
        PanelPagoExito panelPagoExito = new PanelPagoExito(this);
        ponerEnJFrame(panelPagoExito);
        panelActual = panelPagoExito;
    }

    public void cambiarPanelBuscar() throws CafeteriaException{
        limpiarFrame();
        PanelBuscar panelBuscar = new PanelBuscar(this);
        ponerEnJFrame(panelBuscar);
        panelActual = panelBuscar;
    }

    public void cambiarPanelHistorial() {
        limpiarFrame();
        PanelHistorial panelHistorial = new PanelHistorial(this);
        ponerEnJFrame(panelHistorial);
        panelActual = panelHistorial;

    }

    public void cambiarPanelHistorialPedido() {
        limpiarFrame();
        PanelHistorialPedido panelHistorialPedido = new PanelHistorialPedido(this);
        ponerEnJFrame(panelHistorialPedido);
        panelActual = panelHistorialPedido;

    }

    /**
     * Método para agregar un panel a la ventana. Este método agrega el panel
     * especificado a la ventana, lo posiciona y ajusta su tamaño
     * automáticamente.
     *
     * @param panel El panel que se va a agregar a la ventana.
     */
    public void ponerEnJFrame(JPanel panel) {
        this.add(panel);
        panel.setBounds(0, 0, 400, 800);
        this.setLocationRelativeTo(null);
        this.pack();  // Ajustar el tamaño automáticamente
    }

    /**
     * Método para mostrar un aviso al usuario mediante una ventana emergente.
     *
     * @param mensaje El mensaje a mostrar en el aviso.
     */
    public void mostrarAviso(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Método para mostrar una ventana emergente de confirmación al usuario.
     *
     * @param mensaje El mensaje a mostrar en la ventana de confirmación.
     * @param titulo El título de la ventana de confirmación.
     * @return true si el usuario selecciona "OK", false si selecciona
     * "Cancelar".
     */
    public boolean mostrarConfirmacion(String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.OK_CANCEL_OPTION);
        return respuesta == JOptionPane.OK_OPTION;
    }

    /**
     * Método para mostrar una ventana emergente de información al usuario.
     *
     * @param mensaje El mensaje a mostrar en la ventana de información.
     * @param titulo El título de la ventana de información.
     */
    public void mostrarInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Método para mostrar una ventana emergente con dos opciones al usuario.
     *
     * @param mensaje El mensaje a mostrar en la ventana emergente.
     * @param titulo El título de la ventana emergente.
     * @param opcion1 El texto de la primera opción.
     * @param opcion2 El texto de la segunda opción.
     * @return La opción seleccionada por el usuario (1 para la primera opción,
     * 2 para la segunda opción). Si el usuario cierra la ventana sin
     * seleccionar ninguna opción, se devuelve 0.
     */
    public int mostrarOpciones(String mensaje, String titulo, String opcion1, String opcion2) {
        Object[] opciones = {opcion1, opcion2};
        int seleccion = JOptionPane.showOptionDialog(
                this, //Padre
                mensaje, // Mensaje a mostrar
                titulo, // Título del JOptionPane
                JOptionPane.YES_NO_OPTION, // Tipo de opciones (en este caso, Sí/No)
                JOptionPane.QUESTION_MESSAGE, // Tipo de icono (en este caso, pregunta)
                null, // Icono personalizado (en este caso, ninguno)
                opciones, // Opciones a mostrar
                -1); // Opción por defecto seleccionada
        // Ajustar el valor de retorno para que coincida con las opciones (1 y 2)
        return switch (seleccion) {
            case JOptionPane.YES_OPTION ->
                1;
            case JOptionPane.NO_OPTION ->
                2;
            default ->
                0;
        }; // El usuario cerró el JOptionPane o presionó la X para salir
    }

    public String getIdProducto() {
        return codigoProducto;
    }

    public void setIdProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNumID() {
        return numID;
    }

    public void setNumID(String numID) {
        this.numID = numID;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public float getTotalCarrito() {
        return totalCarrito;
    }

    public void setTotalCarrito(float totalCarrito) {
        this.totalCarrito = totalCarrito;
    }

    public String getClaveRecoleccion() {
        return claveRecoleccion;
    }

    public void setClaveRecoleccion(String claveRecoleccion) {
        this.claveRecoleccion = claveRecoleccion;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Integer getPuntosGenerados() {
        return puntosGenerados;
    }

    public void setPuntosGenerados(Integer puntosGenerados) {
        this.puntosGenerados = puntosGenerados;
    }

}
