package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class DetalleUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "names")
    private String nombres;

    @Column(name = "lastnames")
    private String apellidos;

    @Column(name = "email")
    private String correo;

    @Column(name = "address")
    private String direccion;

    @Column(name = "position")
    private String posicion;

    @Column(name = "user_id")
    private String usuarioId;

    public DetalleUsuario(){}


}
