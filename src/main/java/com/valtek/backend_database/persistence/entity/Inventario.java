package com.valtek.backend_database.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codigoProducto;

    @Column(name = "name")
    private String nombreProducto;

    @Column(name = "stock")
    private Integer cantidad;

    @Column(name = "price")
    private Integer precio;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"inventario", "detalleVentasList", "detalleCompraList"})
    private List<DetalleCompra> detalleCompraList;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"inventario", "detalleVentasList", "detalleCompraList"})
    private List<DetalleVentas> detalleVentasList;

    public Inventario(){}

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public List<DetalleCompra> getDetalleCompraList() {
        return detalleCompraList;
    }

    public void setDetalleCompraList(List<DetalleCompra> detalleCompraList) {
        this.detalleCompraList = detalleCompraList;
    }

    public List<DetalleVentas> getDetalleVentasList() {
        return detalleVentasList;
    }

    public void setDetalleVentasList(List<DetalleVentas> detalleVentasList) {
        this.detalleVentasList = detalleVentasList;
    }
}
