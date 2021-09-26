package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "customerType")
public class DetalleCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "discount")
    private Integer descuento;

    @OneToMany(mappedBy = "detalleCliente")
    private List<Cliente> clienteList;

    public DetalleCliente(){

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

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public String toString() {
        return "DetalleCliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descuento=" + descuento +
                ", clienteList=" + clienteList +
                '}';
    }
}
