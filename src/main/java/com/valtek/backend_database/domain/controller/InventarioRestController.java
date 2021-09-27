package com.valtek.backend_database.domain.controller;


import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.Inventario;
import com.valtek.backend_database.persistence.service.InventarioService;
import com.valtek.backend_database.persistence.validate.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://base-de-datos-frontend-14gczqhqb-tatobig.vercel.app/")
@RestController
@RequestMapping("/inventario")
public class InventarioRestController {
    @Autowired
    InventarioService inventarioService;

    public InventarioRestController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/")
    List<Inventario> getAllProducts(){
        return inventarioService.getAllProducts();
    }

    @PostMapping("/")
    ResponseEntity<Inventario> newProduct(@RequestBody RequestDTO requestDTO) throws Exception {
        return new ResponseEntity<>(inventarioService.saveAProduct(requestDTO),HttpStatus.CREATED);
    }

}
