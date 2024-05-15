/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yohan
 */
@Entity
public class UsuarioCIA implements Serializable {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_cia")
    private Long id;

    @Column(name = "id_estudiante", length = 13, nullable = false, unique = true, updatable = false)
    private String idEstudiante;

    @Column(name = "contrasena", length = 64, nullable = false)
    private String contrasena;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 30, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 30, nullable = false)
    private String apellidoMaterno;

    public UsuarioCIA() {
    }

    public UsuarioCIA(String idEstudiante, String contrasena, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.idEstudiante = idEstudiante;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public UsuarioCIA(Long id, String idEstudiante, String contrasena, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
}


