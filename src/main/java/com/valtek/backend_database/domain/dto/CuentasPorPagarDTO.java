package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CuentasPorPagarDTO {
    private Integer total;
    private Integer faltante;
    private LocalDateTime fecha;
    private boolean yapagado;
    private String comprasCodigo;
    private String proveedoresId;
    private String nombre;

    public CuentasPorPagarDTO(){}

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
