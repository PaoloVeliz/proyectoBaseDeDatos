package com.valtek.backend_database.domain.controller;

import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
    private ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    List<Cliente> getAllCostumers(){
        return clienteService.getAllCostumers();
    }


}
