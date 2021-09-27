package com.valtek.backend_database.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "providers")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "names")
    private String nombres;

    @Column(name = "lastnames")
    private String apellidos;

    @Column(name = "email")
    private String correo;

    @Column(name = "address")
    private String direccion;

    @OneToMany(mappedBy = "proveedores", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("proveedores")
    private List<Compra> compraList;

    @OneToMany(mappedBy = "proveedores", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("proveedores")
    private List<CuentasPorPagar> cuentasPorPagarList;

    public Proveedores(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public List<CuentasPorPagar> getCuentasPorPagarList() {
        return cuentasPorPagarList;
    }

    public void setCuentasPorPagarList(List<CuentasPorPagar> cuentasPorPagarList) {
        this.cuentasPorPagarList = cuentasPorPagarList;
    }
}
