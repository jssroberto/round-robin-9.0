package dominio;

/**
 *
 * @author Roberto García
 */
public enum MetodoPago {
    EFECTIVO(0),
    TARJETA(1),
    PUNTOS(2);

    private final int codigo;

    MetodoPago(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    // En la definición del enum MetodoPago
    public static MetodoPago getByCodigo(int codigo) {
        for (MetodoPago metodoPago : MetodoPago.values()) {
            if (metodoPago.getCodigo() == codigo) {
                return metodoPago;
            }
        }
        throw new IllegalArgumentException("Código de método de pago inválido: " + codigo);
    }

}
