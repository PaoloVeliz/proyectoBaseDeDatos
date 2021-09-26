package com.valtek.backend_database.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.valtek.backend_database.persistence.entity.Telefono;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {
    private String nombre;
    private String apellidos;
    private String correo;
    private String direccion;

    private DetalleClienteDTO detalleClienteDTO;
    private List<TelefonoDTO> telefonoDTOS;

    public ClienteDTO() {

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

    public DetalleClienteDTO getDetalleClienteDTO() {
        return detalleClienteDTO;
    }

    public void setDetalleClienteDTO(DetalleClienteDTO detalleClienteDTO) {
        this.detalleClienteDTO = detalleClienteDTO;
    }

    public List<TelefonoDTO> getTelefonoDTOS() {
        return telefonoDTOS;
    }

    public void setTelefonoDTOS(List<TelefonoDTO> telefonoDTOS) {
        this.telefonoDTOS = telefonoDTOS;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", detalleClienteDTO=" + detalleClienteDTO +
                ", telefonoDTOS=" + telefonoDTOS +
                '}';
    }
}
