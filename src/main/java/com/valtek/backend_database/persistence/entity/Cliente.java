package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "costumers")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "names")
    private String nombre;

    @Column(name = "lastnames")
    private String apellidos;

    @Column(name = "email")
    private String correo;

    @Column(name = "address")
    private String direccion;

    @Column(name = "costumersdetails_id")
    private String detalleclientesId;

    public Cliente(){}

    public Cliente(String id, String nombre, String apellidos, String correo, String direccion, String detalleclientesId) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.detalleclientesId = detalleclientesId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getDetalleclientesId() {
        return detalleclientesId;
    }

    public void setDetalleclientesId(String detalleclientesId) {
        this.detalleclientesId = detalleclientesId;
    }
}
