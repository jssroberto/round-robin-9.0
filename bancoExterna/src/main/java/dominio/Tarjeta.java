package dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author Roberto García
 */
public class Tarjeta {

    private ObjectId id;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private Integer cvv;
    private Float saldo;
    
    public Tarjeta() {
    }

    public Tarjeta(String numeroTarjeta, String fechaVencimiento, Integer cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    public Tarjeta(ObjectId id, String numeroTarjeta, String fechaVencimiento, Integer cvv) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    public Tarjeta(String numeroTarjeta, String fechaVencimiento, Integer cvv, Float saldo) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.saldo = saldo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

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
