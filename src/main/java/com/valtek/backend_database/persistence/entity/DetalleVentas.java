package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "salesdetails")
public class DetalleVentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String  id;

    @Column(name = "costumers_id")
    private Integer clientesId;

    @Column(name = "date")
    private LocalDateTime fecha;

    @Column(name = "names")
    private String nombre;

    @Column(name = "amount")
    private Integer cantidad;

    @Column(name = "price")
    private Integer precio;

    private Integer total;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Venta venta;

    @Column(name = "product_id")
    private Integer productoId;

    public DetalleVentas(){}

    public DetalleVentas(String id, Integer clientesId, LocalDateTime fecha, String nombre, Integer cantidad, Integer precio, Integer total, Integer productoId, Venta venta) {
        this.id = id;
        this.clientesId = clientesId;
        this.fecha = fecha;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.venta = venta;
        this.productoId = productoId;
    }
    public Venta getVenta(){
            return venta;
    }
    public void setVenta(Venta venta){
        this.venta = venta;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
