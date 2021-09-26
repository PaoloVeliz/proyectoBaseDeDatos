package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDTO {
    @JsonProperty("detalle_cliente")
    private DetalleClienteDTO detalleClienteDTO;

    @JsonProperty("cliente")
    private ClienteDTO clienteDTO;

    @JsonProperty("telefonos")
    private List<TelefonoDTO> telefonoDTO;

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public DetalleClienteDTO getDetalleClienteDTO() {
        return detalleClienteDTO;
    }

    public void setDetalleClienteDTO(DetalleClienteDTO detalleClienteDTO) {
        this.detalleClienteDTO = detalleClienteDTO;
    }
}
