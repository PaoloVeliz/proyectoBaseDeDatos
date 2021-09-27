package com.valtek.backend_database.domain.controller;


import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.domain.repository.DetalleVentasRepository;
import com.valtek.backend_database.persistence.entity.*;
import com.valtek.backend_database.persistence.service.CompraService;
import com.valtek.backend_database.persistence.service.CuentasPorCobrarService;
import com.valtek.backend_database.persistence.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ventas")
public class VentaRestController {
    @Autowired
    VentaService ventaService;

    @PostMapping("/")
    ResponseEntity<Venta> newSale(@RequestBody RequestDTO requestDTO) throws Exception {
        return new ResponseEntity<>(ventaService.saveSale(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/")
    List<Venta> getAllPurchases () {
        return ventaService.getAllSales();
    }
}
