package com.valtek.backend_database.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases", indexes = @Index(name = "purchase_provider_id", columnList = "provider_id"))
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDateTime fecha;

    @Column(name = "total")
    private Integer total;

    @Column(name = "alreadypaid")
    private boolean yapagado;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    @JsonIgnoreProperties("compraList")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    @JsonIgnoreProperties("compraList")
    private Proveedores proveedores;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("compra")
    private List<DetalleCompra> detalleCompraList;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("compra")
    private List<CuentasPorPagar> cuentasPorPagarList;

    public Compra(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isYapagado() {
        return yapagado;
    }

    public void setYapagado(boolean yapagado) {
        this.yapagado = yapagado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public List<DetalleCompra> getDetalleCompraList() {
        return detalleCompraList;
    }

    public void setDetalleCompraList(List<DetalleCompra> detalleCompraList) {
        this.detalleCompraList = detalleCompraList;
    }

    public List<CuentasPorPagar> getCuentasPorPagarList() {
        return cuentasPorPagarList;
    }

    public void setCuentasPorPagarList(List<CuentasPorPagar> cuentasPorPagarList) {
        this.cuentasPorPagarList = cuentasPorPagarList;
    }
}
