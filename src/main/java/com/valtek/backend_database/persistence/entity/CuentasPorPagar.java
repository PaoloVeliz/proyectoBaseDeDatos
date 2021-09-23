package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "debts")
public class CuentasPorPagar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer total;

    @Column(name = "wanting")
    private Integer faltante;

    @Column(name = "date")
    private LocalDateTime fecha;

    @Column(name = "alreadypaid")
    private boolean yapagado;

    @Column(name = "purchases_id")
    private String comprasCodigo;

    @Column(name = "providers_id")
    private String proveedoresId;

    @Column(name = "names")
    private String nombre;

    public CuentasPorPagar(){}

    public CuentasPorPagar(String id, Integer total, Integer faltante, LocalDateTime fecha, boolean yapagado, String comprasCodigo, String proveedoresId, String nombre) {
        this.id = id;
        this.total = total;
        this.faltante = faltante;
        this.fecha = fecha;
        this.yapagado = yapagado;
        this.comprasCodigo = comprasCodigo;
        this.proveedoresId = proveedoresId;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getFaltante() {
        return faltante;
    }

    public void setFaltante(Integer faltante) {
        this.faltante = faltante;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public boolean isYapagado() {
        return yapagado;
    }

    public void setYapagado(boolean yapagado) {
        this.yapagado = yapagado;
    }

    public String getComprasCodigo() {
        return comprasCodigo;
    }

    public void setComprasCodigo(String comprasCodigo) {
        this.comprasCodigo = comprasCodigo;
    }

    public String getProveedoresId() {
        return proveedoresId;
    }

    public void setProveedoresId(String proveedoresId) {
        this.proveedoresId = proveedoresId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
