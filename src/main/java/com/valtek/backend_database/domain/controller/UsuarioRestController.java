package com.valtek.backend_database.domain.controller;

import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.persistence.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    List<Usuario> get() {
        return usuarioService.getAllUsers();
    }

    @PostMapping("/")
    ResponseEntity<Usuario> newUser(@RequestBody Usuario user) {
        return new ResponseEntity<>(usuarioService.createOneUser(user), HttpStatus.CREATED);
    }
}
