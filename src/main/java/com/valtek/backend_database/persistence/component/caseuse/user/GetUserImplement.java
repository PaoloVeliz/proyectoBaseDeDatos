package com.valtek.backend_database.persistence.component.caseuse.user;

import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.persistence.service.UsuarioService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UsuarioService usuarioService;

    public GetUserImplement(){}

    public GetUserImplement(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioService.getAllUsers();
    }
}
