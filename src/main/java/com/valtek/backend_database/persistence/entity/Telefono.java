package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "number")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Cliente cliente;

    public Telefono() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "id='" + id + '\'' +
                ", numero='" + numero + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
