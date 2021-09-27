package com.valtek.backend_database.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "lastname")
    private String apellidos;

    @Column(name = "email")
    private String correo;

    @Column(name = "address")
    private String direccion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    @JsonIgnoreProperties("clienteList")
    private DetalleCliente detalleCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<Telefono> telefonoList;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<Venta> ventaList;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<CuentasPorCobrar> cuentasPorCobrarList;




    public Cliente(){}

    public Cliente(String nombre, String apellidos, String correo, String direccion, DetalleCliente detalleCliente) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.detalleCliente = detalleCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public DetalleCliente getDetalleCliente() {
        return detalleCliente;
    }

    public void setDetalleCliente(DetalleCliente detalleCliente) {
        this.detalleCliente = detalleCliente;
    }

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public List<CuentasPorCobrar> getCuentasPorCobrarList() {
        return cuentasPorCobrarList;
    }

    public void setCuentasPorCobrarList(List<CuentasPorCobrar> cuentasPorCobrarList) {
        this.cuentasPorCobrarList = cuentasPorCobrarList;
    }
}
