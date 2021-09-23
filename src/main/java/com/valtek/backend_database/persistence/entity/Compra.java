package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "date")
    private LocalDateTime fecha;

    private Integer total;

    @Column(name = "alreadypaid")
    private boolean yapagado;

    @Column(name = "providers_id")
    private Integer proveedoresId;

    @Column(name = "names")
    private String nombre;

    public Compra(){}

    public Compra(String id, LocalDateTime fecha, Integer total, boolean yapagado, Integer proveedoresId, String nombre) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.yapagado = yapagado;
        this.proveedoresId = proveedoresId;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isYapagado() {
        return yapagado;
    }

    public void setYapagado(boolean yapagado) {
        this.yapagado = yapagado;
    }

    public Integer getProveedoresId() {
        return proveedoresId;
    }

    public void setProveedoresId(Integer proveedoresId) {
        this.proveedoresId = proveedoresId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
