package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {
    private String nombre;
    private String apellidos;
    private String correo;
    private String direccion;

    private Integer detalleCliente_id;

    @JsonProperty("telefonos")
    private List<TelefonoDTO> telefonoDTO;

    public ClienteDTO() {

    }

    public List<TelefonoDTO> getTelefonoDTO() {
        return telefonoDTO;
    }

    public void setTelefonoDTO(List<TelefonoDTO> telefonoDTO) {
        this.telefonoDTO = telefonoDTO;
    }

    public Integer getDetalleCliente_id() {
        return detalleCliente_id;
    }

    public void setDetalleCliente_id(Integer detalleCliente_id) {
        this.detalleCliente_id = detalleCliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
