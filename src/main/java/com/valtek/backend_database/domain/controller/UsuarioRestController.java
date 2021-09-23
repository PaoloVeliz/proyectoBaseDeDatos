package com.valtek.backend_database.domain.controller;

import com.valtek.backend_database.persistence.component.caseuse.user.GetUser;
import com.valtek.backend_database.persistence.entity.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
    private GetUser getUser;

    public UsuarioRestController(){}

    public UsuarioRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<Usuario> get(){
     return getUser.getAll();
    }
}
