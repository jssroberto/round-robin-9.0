package dominio;

import org.bson.types.ObjectId;

/**
 * Clase que representa un producto de cafetería.
 *
 * @author José Luis Madero López
 * @author Jesús Roberto García Armenta
 * @author Yohan Gabriel Melendrez Leal
 * @author Pablo Jesús Galán Valenzuela
 */
public class ProductoCafeteria {

    // Identificador único del producto
    private ObjectId id;
    // Precio del producto
    private Float precio;
    // Nombre del producto
    private String nombre;
    // Descripción del producto
    private String descripcion;
    // Cantidad disponible del producto
    private Integer cantidadDisponible;
    // Dirección de la imagen del producto
    private String direccionImagen;
    // Código único del producto
    private String codigo;

    /**
     * Constructor que inicializa un producto de cafetería con todos sus
     * atributos.
     *
     * @param id el identificador único del producto.
     * @param precio el precio del producto.
     * @param nombre el nombre del producto.
     * @param descripcion la descripción del producto.
     * @param cantidadDisponible la cantidad disponible del producto.
     * @param direccionImagen la dirección de la imagen del producto.
     * @param codigo el código único del producto.
     */
    public ProductoCafeteria(ObjectId id, Float precio, String nombre, String descripcion, Integer cantidadDisponible, String direccionImagen, String codigo) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
        this.direccionImagen = direccionImagen;
        this.codigo = codigo;
    }

    /**
     * Constructor que inicializa un producto de cafetería sin el identificador
     * único.
     *
     * @param codigo el código único del producto.
     * @param precio el precio del producto.
     * @param nombre el nombre del producto.
     * @param descripcion la descripción del producto.
     * @param cantidadDisponible la cantidad disponible del producto.
     * @param direccionImagen la dirección de la imagen del producto.
     */
    public ProductoCafeteria(String codigo, Float precio, String nombre, String descripcion, Integer cantidadDisponible, String direccionImagen) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
        this.direccionImagen = direccionImagen;
        this.codigo = codigo;
    }

    /**
     * Constructor vacío para la clase ProductoCafeteria.
     */
    public ProductoCafeteria() {
    }

    // Getters y Setters
    /**
     * Obtiene el identificador único del producto.
     *
     * @return el identificador único del producto.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param id el identificador único del producto.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return el precio del producto.
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio el precio del producto.
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return el nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre el nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return la descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion la descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return la cantidad disponible del producto.
     */
    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidadDisponible la cantidad disponible del producto.
     */
    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Obtiene la dirección de la imagen del producto.
     *
     * @return la dirección de la imagen del producto.
     */
    public String getDireccionImagen() {
        return direccionImagen;
    }

    /**
     * Establece la dirección de la imagen del producto.
     *
     * @param direccionImagen la dirección de la imagen del producto.
     */
    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    /**
     * Obtiene el código único del producto.
     *
     * @return el código único del producto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código único del producto.
     *
     * @param codigo el código único del producto.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve una representación de cadena de este objeto.
     *
     * @return una cadena que representa este objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductoCafeteria{");
        sb.append("id=").append(id);
        sb.append(", precio=").append(precio);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", cantidadDisponible=").append(cantidadDisponible);
        sb.append(", direccionImagen=").append(direccionImagen);
        sb.append(", codigo=").append(codigo);
        sb.append('}');
        return sb.toString();
    }

}
