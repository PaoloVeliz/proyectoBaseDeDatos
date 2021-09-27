package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.valtek.backend_database.persistence.entity.DetalleVentas;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VentaDTO {
    private LocalDateTime fecha;
    private Integer total;
    private boolean yapagado;
    private String clientesId;
    public DetalleVentas detalleVentas;
    private String nombre;
    private String usuarioId;

    public VentaDTO(){}

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

    public String getClientesId() {
        return clientesId;
    }

    public void setClientesId(String clientesId) {
        this.clientesId = clientesId;
    }

    public DetalleVentas getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(DetalleVentas detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
