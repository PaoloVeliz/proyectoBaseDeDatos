package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraDTO {
    private LocalDateTime fecha;
    private Integer total;
    private boolean yapagado;
    private Integer proveedoresId;
    private String nombre;
    private String usuarioId;

    public CompraDTO (){}

    @JsonProperty("detalle_compra")
    private List<DetalleCompraDTO> detalleCompraDTO;

    public List<DetalleCompraDTO> getDetalleCompraDTO() {
        return detalleCompraDTO;
    }

    public void setDetalleCompraDTO(List<DetalleCompraDTO> detalleCompraDTO) {
        this.detalleCompraDTO = detalleCompraDTO;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
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
