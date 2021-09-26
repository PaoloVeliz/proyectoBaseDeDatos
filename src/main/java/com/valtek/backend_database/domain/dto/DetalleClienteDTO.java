package com.valtek.backend_database.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetalleClienteDTO {
    private String nombre;
    private Integer descuento;
    private List<ClienteDTO> clienteDTOS;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public List<ClienteDTO> getClienteDTOS() {
        return clienteDTOS;
    }

    public void setClienteDTOS(List<ClienteDTO> clienteDTOS) {
        this.clienteDTOS = clienteDTOS;
    }
}
