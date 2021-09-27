package com.valtek.backend_database.domain.controller;


import com.valtek.backend_database.persistence.entity.Inventario;
import com.valtek.backend_database.persistence.service.InventarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inventario")
public class InventarioRestController {
    /* private final InventarioService inventarioService;

    public InventarioRestController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/getallproducts")
    public List<Inventario> getAllProducts(){
        return inventarioService.getAllProducts();
    }

    @GetMapping("/getaproduct")
    public Optional<Inventario> getAProductById(String codigoProducto){
        return inventarioService.getAProduct(codigoProducto);
    }

    @PostMapping("/")
    ResponseEntity<Inventario> newProduct(@RequestBody Inventario inventario){
        return new ResponseEntity<>(inventarioService.saveProduct(inventario), HttpStatus.CREATED);
    }*/


}
