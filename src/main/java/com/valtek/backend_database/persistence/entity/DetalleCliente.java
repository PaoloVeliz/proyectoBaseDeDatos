package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "costumersdetails")
public class DetalleCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private Integer tipo;

    @Column(name = "discount")
    private Integer descuento;

    public DetalleCliente(){}

    public DetalleCliente(String id, Integer tipo, Integer descuento) {
        this.id = id;
        this.tipo = tipo;
        this.descuento = descuento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }
}
