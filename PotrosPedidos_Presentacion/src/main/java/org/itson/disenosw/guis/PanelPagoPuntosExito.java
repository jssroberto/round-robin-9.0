package org.itson.disenosw.guis;

import BOs.UsuarioBO;
import Interfaz.IUsuarioBO;
import control.ControlUsuario;
import dominio.DetalleProducto;
import dominio.Usuario;
import interfaces.ICalcularCostoPuntos;
import interfaces.IControlUsuario;
import interfaces.IGenerarPuntos;
import interfaces.IPagarPuntos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metodos.CalcularCostoPuntos;
import metodos.GenerarPuntos;
import metodos.PagarPuntos;

/**
 * Esta clase representa la vista de inicio de sesión en la interfaz gráfica del
 * banco. Permite a los usuarios iniciar sesión proporcionando su nombre de
 * usuario y contraseña.
 */
public class PanelPagoPuntosExito extends javax.swing.JPanel {

    private FramePrincipal ventana;

    /**
     * Constructor de la clase VistaInicioSesion.
     *
     * @param ventana La ventana principal de la aplicación.
     */
    public PanelPagoPuntosExito(FramePrincipal ventana) {
        try {
            this.ventana = ventana;
            initComponents();

            IUsuarioBO usuarioBO = new UsuarioBO();
            IControlUsuario user = new ControlUsuario();
            Usuario u = new Usuario();
            u.setIdCia(ventana.getNumID());
            Usuario usuarioBueno = usuarioBO.consultarUsuario(u);
            List<DetalleProducto> detallesCarritos = usuarioBueno.getCarrito().getProductos();
            ICalcularCostoPuntos calcularPuntos = new CalcularCostoPuntos();

            lblPuntosDisponibles.setText(usuarioBueno.getSaldoPuntos().toString() + " puntos");
            lblPuntosRequeridos.setText(calcularPuntos.calcularCostoPuntos(detallesCarritos) + " puntos");
            Integer puntosRestantes = usuarioBueno.getSaldoPuntos() - calcularPuntos.calcularCostoPuntos(detallesCarritos);
            lblPuntosRestantes.setText(puntosRestantes.toString() + " puntos");
        } catch (Exception ex) {
            Logger.getLogger(PanelPagoPuntosExito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPuntosDisponibles = new javax.swing.JLabel();
        lblPuntosRequeridos = new javax.swing.JLabel();
        lblPuntosRestantes = new javax.swing.JLabel();
        btnConfirmarPago = new javax.swing.JButton();
        btnRegresarMenu = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(400, 800));
        setMinimumSize(new java.awt.Dimension(400, 800));
        setPreferredSize(new java.awt.Dimension(400, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(lblPuntosDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 360, 40));
        add(lblPuntosRequeridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 360, 40));
        add(lblPuntosRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 350, 40));

        btnConfirmarPago.setBorder(null);
        btnConfirmarPago.setContentAreaFilled(false);
        btnConfirmarPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPagoActionPerformed(evt);
            }
        });
        add(btnConfirmarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 170, 60));

        btnRegresarMenu.setBorder(null);
        btnRegresarMenu.setContentAreaFilled(false);
        btnRegresarMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuActionPerformed(evt);
            }
        });
        add(btnRegresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 60, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panelPagoPuntosExito.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPagoActionPerformed
        IUsuarioBO usuarioBO = new UsuarioBO();
        IControlUsuario user = new ControlUsuario();
        Usuario u = new Usuario();
        u.setIdCia(ventana.getNumID());
        Usuario usuarioBueno = usuarioBO.consultarUsuario(u);
        List<DetalleProducto> detallesCarritos = usuarioBueno.getCarrito().getProductos();
        ICalcularCostoPuntos calcularPuntos = new CalcularCostoPuntos();
        IGenerarPuntos generarPuntos = new GenerarPuntos();

        IPagarPuntos pagarPuntos = new PagarPuntos();
        try {
            ArrayList<String> info= (ArrayList<String>) pagarPuntos.PagarPuntos(usuarioBueno, calcularPuntos.calcularCostoPuntos(detallesCarritos), generarPuntos.generarPuntos(detallesCarritos));
            info.get(0);
            ventana.mostrarConfirmacion("PEDIDO EXITOSO", "EXITO");
            ventana.cambiarPanelPagoExitoPuntos(generarPuntos.generarPuntos(detallesCarritos), info.get(0), info.get(1));
        } catch (Exception ex) {
            ventana.mostrarAviso("Algo ha ocurrido mal", "ERROR");
            ventana.cambiarVistaMetodoPago();
            Logger.getLogger(PanelPagoPuntosExito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarPagoActionPerformed

    private void btnRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuActionPerformed
        ventana.cambiarVistaMetodoPago();
    }//GEN-LAST:event_btnRegresarMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarPago;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblPuntosDisponibles;
    private javax.swing.JLabel lblPuntosRequeridos;
    private javax.swing.JLabel lblPuntosRestantes;
    // End of variables declaration//GEN-END:variables
}