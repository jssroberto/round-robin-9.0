package org.itson.disenosw.guis;

import control.ControlCarrito;
import control.ControlPedido;
import control.ControlTarjeta;
import control.ControlUsuario;
import dominio.MetodoPago;
import dominio.Pedido;
import dominio.Tarjeta;
import dominio.Usuario;
import excepciones.BancoException;
import interfaces.IControlCarrito;
import interfaces.IControlPedido;
import interfaces.IControlTarjeta;
import interfaces.IControlUsuario;
import java.time.LocalDate;

import java.util.logging.Logger;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Esta clase representa la vista de inicio de sesión en la interfaz gráfica del
 * banco. Permite a los usuarios iniciar sesión proporcionando su nombre de
 * usuario y contraseña.
 */
public class PanelDatosTarjeta extends javax.swing.JPanel {

    private static final Logger logger = Logger.getLogger(PanelMenu.class.getName());
    private FramePrincipal framePrincipal;

    /**
     * Constructor de la clase VistaInicioSesion.
     *
     * @param framePrincipal La framePrincipal principal de la aplicación.
     */
    public PanelDatosTarjeta(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        initComponents();
        ((AbstractDocument) txtNumero.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[0-9-]*")) { // Solo permite números
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[0-9-]*")) { // Solo permite números
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        ((AbstractDocument) txtcvv.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[0-9]*")) { // Solo permite números
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[0-9]*")) { // Solo permite números
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        ((AbstractDocument) txtNombre.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[a-zA-Z]*")) { // Solo permite letras
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[a-zA-Z]*")) { // Solo permite letras
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        ((AbstractDocument) txtfecha.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[0-9/]*")) { // Solo permite números y la diagonal "/"
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("[0-9/]*")) { // Solo permite números y la diagonal "/"
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
//        b.generarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenu = new javax.swing.JButton();
        txtcvv = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(400, 800));
        setMinimumSize(new java.awt.Dimension(400, 800));
        setPreferredSize(new java.awt.Dimension(400, 800));
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

        txtcvv.setBorder(null);
        add(txtcvv, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 80, 30));

        txtfecha.setBorder(null);
        add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 90, 30));

        txtNombre.setBorder(null);
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 340, 30));

        txtNumero.setBorder(null);
        add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 340, 30));

        btnPagar.setBorder(null);
        btnPagar.setContentAreaFilled(false);
        btnPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 120, 50));

        btnRegresar.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 50, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panelDatosTarjeta.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (!(txtNombre.getText().equalsIgnoreCase("") || txtNumero.getText().equalsIgnoreCase("") | txtcvv.getText().equalsIgnoreCase("") || txtfecha.getText().equalsIgnoreCase(""))) {
            IControlPedido pedido = new ControlPedido();
            IControlUsuario usuario = new ControlUsuario();
            IControlCarrito carrito = new ControlCarrito();
            IControlTarjeta tarjeta = new ControlTarjeta();
            Usuario user = new Usuario();
            Tarjeta tar = new Tarjeta();
            tar.setNumeroTarjeta(txtNumero.getText());
            tar.setCvv(Integer.parseInt(txtcvv.getText()));
            tar.setFechaVencimiento(txtfecha.getText());
            user.setIdCia(framePrincipal.getNumID());
            Usuario usuarioNuevo = usuario.consultarUsuario(user);
            try {
                if (tarjeta.validarDatos(tar)) {
                    framePrincipal.mostrarAviso("Tarjeta válida", "Aviso");
                    if (tarjeta.validacionCompra(tar, framePrincipal.getTotalCarrito())) {
                        framePrincipal.mostrarAviso("Compra procesada con éxito", "Aviso");
                        Pedido pedidoNuevo = new Pedido("", Integer.toString(framePrincipal.getNumPedido()), "", LocalDate.now(), usuarioNuevo.getCarrito().getProductos().size(), 0.0f, MetodoPago.TARJETA, usuarioNuevo.getCarrito().getProductos());
                        pedidoNuevo.setClaveRecoleccion(pedido.generateRandomString());
                        pedidoNuevo.setEtiquetaPedido(pedido.generateRandomString());
                        pedido.persistir(pedidoNuevo);
                        pedido.referenciarPedido(usuarioNuevo, pedido.consultarPedido(pedidoNuevo));
                        carrito.vaciarCarrito(usuarioNuevo);
                        framePrincipal.setClaveRecoleccion(pedidoNuevo.getClaveRecoleccion());
                        framePrincipal.cambiarPanelPagoExito();
                    } else {
                        framePrincipal.mostrarAviso("Saldo insuficiente", "Aviso");
                        framePrincipal.cambiarVistaMetodoPago();
                    }
                } else {
                    framePrincipal.mostrarAviso("Datos no válidos", "Aviso");
                }
            } catch (IllegalArgumentException | BancoException ex) {
                framePrincipal.mostrarAviso("Vuelva a intentarlo", "Aviso");
            }

        } else {
            framePrincipal.mostrarAviso("Rellena todos los campos", "AVISO");
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        framePrincipal.cambiarVistaMetodoPago();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        framePrincipal.cambiarVistaMenu();
    }//GEN-LAST:event_btnMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtcvv;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
