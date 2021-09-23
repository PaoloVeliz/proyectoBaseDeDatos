package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchasesdetails")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "providers_id")
    private Integer proveedoresId;

    @Column(name = "date")
    private LocalDateTime fecha;

    @Column(name = "amount")
    private Integer cantidad;

    @Column(name = "purchases_id")
    private String comprasId;

    @Column(name = "price")
    private Integer precio;

    @Column(name = "product_id")
    private Integer codigoProducto;

    private Integer total;

    @Column(name = "names")
    private String nombre;


    public DetalleCompra(){}

    public DetalleCompra(String id, Integer proveedoresId, LocalDateTime fecha, Integer cantidad, String comprasId, Integer precio, Integer codigoProducto, Integer total, String nombre) {
        this.id = id;
        this.proveedoresId = proveedoresId;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.comprasId = comprasId;
        this.precio = precio;
        this.codigoProducto = codigoProducto;
        this.total = total;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProveedoresId() {
        return proveedoresId;
    }

    public void setProveedoresId(Integer proveedoresId) {
        this.proveedoresId = proveedoresId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getComprasId() {
        return comprasId;
    }

    public void setComprasId(String comprasId) {
        this.comprasId = comprasId;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
