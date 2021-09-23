package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class DetalleUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "names")
    private String nombres;

    @Column(name = "lastnames")
    private String apellidos;

    @Column(name = "email")
    private String correo;

    @Column(name = "address")
    private String direccion;

    @Column(name = "position")
    private String posicion;

    @Column(name = "user_id")
    private String usuarioId;

    public DetalleUsuario(){}

    public DetalleUsuario(String id, String nombres, String apellidos, String correo, String direccion, String posicion, String usuarioId) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.posicion = posicion;
        this.usuarioId = usuarioId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
