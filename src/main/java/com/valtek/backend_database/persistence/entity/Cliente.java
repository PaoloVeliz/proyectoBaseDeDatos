package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "lastname")
    private String apellidos;

    @Column(name = "email")
    private String correo;

    @Column(name = "address")
    private String direccion;

    @ManyToOne
    @JoinColumn(name="customerType_id")
    private DetalleCliente detalleCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefonos;

    public Cliente(){}

    public Cliente(String nombre, String apellidos, String correo, String direccion, DetalleCliente detalleCliente, List<Telefono> telefonos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.detalleCliente = detalleCliente;
        this.telefonos = telefonos;
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

    public DetalleCliente getDetalleCliente() {
        return detalleCliente;
    }

    public void setDetalleCliente(DetalleCliente detalleCliente) {
        this.detalleCliente = detalleCliente;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", detalleCliente=" + detalleCliente +
                ", telefonos=" + telefonos +
                '}';
    }
}
