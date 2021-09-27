package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.CuentasPorCobrar;
import com.valtek.backend_database.persistence.entity.DetalleVentas;
import com.valtek.backend_database.persistence.entity.Usuario;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VentaDTO {

    private LocalDateTime fecha;
    private Integer total;
    private boolean yapagado;
    public String usuarioId;
    public Integer clienteId;
    public VentaDTO(){}

    @JsonProperty("detalle_venta")
    private List<DetalleVentasDTO> detalleVentasDTO;

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

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public List<DetalleVentasDTO> getDetalleVentasDTO() {
        return detalleVentasDTO;
    }

    public void setDetalleVentasDTO(List<DetalleVentasDTO> detalleVentasDTO) {
        this.detalleVentasDTO = detalleVentasDTO;
    }

}
