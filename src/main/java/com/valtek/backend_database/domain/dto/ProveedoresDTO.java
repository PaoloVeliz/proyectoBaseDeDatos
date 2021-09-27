package com.valtek.backend_database.domain.dto;

public class ProveedoresDTO {
    private String nombres;
    private String apellidos;
    private String direccion;
    private String correo;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return correo;
    }

    public void setEmail(String correo) {
        this.correo = correo;
    }
}
