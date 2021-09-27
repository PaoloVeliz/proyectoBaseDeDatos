package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CuentasPorCobrarDTO {
    private Integer total;
    private Integer faltante;
    private LocalDateTime fecha;
    private String ventasId;
    private Integer clientesId;
    private boolean yapagado;

    public CuentasPorCobrarDTO(){}

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

    public boolean getYapagado() {
        return yapagado;
    }

    public void setYapagado(Boolean yapagado) {
        this.yapagado = yapagado;
    }
}
