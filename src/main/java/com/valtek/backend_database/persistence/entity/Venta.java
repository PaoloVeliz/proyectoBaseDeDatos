package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "date")
    private LocalDateTime fecha;

    private Integer total;

    @Column(name = "alreadypaid")
    private boolean yapagado;

    @Column(name = "costumers_id")
    private Integer clientesId;

    @Column(name = "names")
    private String nombre;

    @Column(name = "user_id")
    private String usuarioId;

    public Venta(){}

    public Venta(String id, LocalDateTime fecha, Integer total, boolean yapagado, Integer clientesId, String nombre, String usuarioId) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.yapagado = yapagado;
        this.clientesId = clientesId;
        this.nombre = nombre;
        this.usuarioId = usuarioId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
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

    public Integer getClientesId() {
        return clientesId;
    }

    public void setClientesId(Integer clientesId) {
        this.clientesId = clientesId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
