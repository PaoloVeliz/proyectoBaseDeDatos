package com.valtek.backend_database.domain.controller;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.persistence.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://base-de-datos-frontend-14gczqhqb-tatobig.vercel.app/")
@RestController
@RequestMapping("/users")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    List<Usuario> getUsers() {
        return usuarioService.getAllUsers();
    }

    @PostMapping("/login/")
    ResponseEntity<Usuario> login(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(usuarioService.getUserById(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/")
    ResponseEntity<Usuario> newUser(@RequestBody Usuario user) {
        System.out.println(user.toString());
        return new ResponseEntity<>(usuarioService.createOneUser(user), HttpStatus.CREATED);
    }


}
