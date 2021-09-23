package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "receivables")
public class CuentasPorCobrar {
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

    @Column(name = "sales_id")
    private String ventasId;

    @Column(name = "costumers_id")
    private Integer clientesId;

    public CuentasPorCobrar(){}

    public CuentasPorCobrar(String id, Integer total, Integer faltante, LocalDateTime fecha, boolean yapagado, String ventasId, Integer clientesId) {
        this.id = id;
        this.total = total;
        this.faltante = faltante;
        this.fecha = fecha;
        this.yapagado = yapagado;
        this.ventasId = ventasId;
        this.clientesId = clientesId;
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

    public String getVentasId() {
        return ventasId;
    }

    public void setVentasId(String ventasId) {
        this.ventasId = ventasId;
    }

    public Integer getClientesId() {
        return clientesId;
    }

    public void setClientesId(Integer clientesId) {
        this.clientesId = clientesId;
    }
}
