package com.valtek.backend_database.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "number")
    private String numero;

    @Column(name = "ownerId")
    private String personaId;

    public String getId() {
        return id;
    }

    public Telefono(){}

    public Telefono(String id, String numero, String personaId) {
        this.id = id;
        this.numero = numero;
        this.personaId = personaId;
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

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }
}
