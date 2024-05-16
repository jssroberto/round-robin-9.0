package dominio;

import org.bson.types.ObjectId;

/**
 * Clase que representa una Tarjeta con atributos como número de tarjeta, fecha
 * de vencimiento, CVV y saldo. Proporciona métodos para obtener y establecer
 * estos atributos.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class Tarjeta {

    private ObjectId id;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private Integer cvv;
    private Float saldo;

    /**
     * Constructor por defecto.
     */
    public Tarjeta() {
    }

    /**
     * Constructor que inicializa la tarjeta con el número, fecha de vencimiento
     * y CVV.
     *
     * @param numeroTarjeta el número de la tarjeta.
     * @param fechaVencimiento la fecha de vencimiento de la tarjeta.
     * @param cvv el código CVV de la tarjeta.
     */
    public Tarjeta(String numeroTarjeta, String fechaVencimiento, Integer cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    /**
     * Constructor que inicializa la tarjeta con el ID, número, fecha de
     * vencimiento y CVV.
     *
     * @param id el ID de la tarjeta.
     * @param numeroTarjeta el número de la tarjeta.
     * @param fechaVencimiento la fecha de vencimiento de la tarjeta.
     * @param cvv el código CVV de la tarjeta.
     */
    public Tarjeta(ObjectId id, String numeroTarjeta, String fechaVencimiento, Integer cvv) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    /**
     * Constructor que inicializa la tarjeta con el número, fecha de
     * vencimiento, CVV y saldo.
     *
     * @param numeroTarjeta el número de la tarjeta.
     * @param fechaVencimiento la fecha de vencimiento de la tarjeta.
     * @param cvv el código CVV de la tarjeta.
     * @param saldo el saldo de la tarjeta.
     */
    public Tarjeta(String numeroTarjeta, String fechaVencimiento, Integer cvv, Float saldo) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.saldo = saldo;
    }

    /**
     * Obtiene el ID de la tarjeta.
     *
     * @return el ID de la tarjeta.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID de la tarjeta.
     *
     * @param id el nuevo ID de la tarjeta.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el número de la tarjeta.
     *
     * @return el número de la tarjeta.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de la tarjeta.
     *
     * @param numeroTarjeta el nuevo número de la tarjeta.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     *
     * @return la fecha de vencimiento de la tarjeta.
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento de la tarjeta.
     *
     * @param fechaVencimiento la nueva fecha de vencimiento de la tarjeta.
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtiene el código CVV de la tarjeta.
     *
     * @return el código CVV de la tarjeta.
     */
    public Integer getCvv() {
        return cvv;
    }

    /**
     * Establece el código CVV de la tarjeta.
     *
     * @param cvv el nuevo código CVV de la tarjeta.
     */
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    /**
     * Obtiene el saldo de la tarjeta.
     *
     * @return el saldo de la tarjeta.
     */
    public Float getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la tarjeta.
     *
     * @param saldo el nuevo saldo de la tarjeta.
     */
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    /**
     * Devuelve una representación en cadena de la tarjeta.
     *
     * @return una cadena que representa la tarjeta.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarjeta{");
        sb.append("id=").append(id);
        sb.append(", numeroTarjeta=").append(numeroTarjeta);
        sb.append(", fechaVencimiento=").append(fechaVencimiento);
        sb.append(", cvv=").append(cvv);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}
