package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDTO {
    @JsonProperty("detalle_cliente")
    private DetalleClienteDTO detalleClienteDTO;

    public DetalleClienteDTO getDetalleClienteDTO() {
        return detalleClienteDTO;
    }

    public void setDetalleClienteDTO(DetalleClienteDTO detalleClienteDTO) {
        this.detalleClienteDTO = detalleClienteDTO;
    }
}
