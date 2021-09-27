package com.valtek.backend_database.domain.controller;


import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.*;
import com.valtek.backend_database.persistence.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/compras")
public class CompraRestController {
    @Autowired
    CompraService compraService;

    @PostMapping("/")
    ResponseEntity<Compra> newPurchase(@RequestBody RequestDTO requestDTO) throws Exception {
        return new ResponseEntity<>(compraService.savePurchase(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/")
    List<Compra> getAllPurchases () {
        return compraService.getAllPurchases();
    }
}
