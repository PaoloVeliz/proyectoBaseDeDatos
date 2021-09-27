package com.valtek.backend_database.domain.controller;


import com.valtek.backend_database.domain.repository.DetalleVentasRepository;
import com.valtek.backend_database.persistence.entity.CuentasPorCobrar;
import com.valtek.backend_database.persistence.entity.DetalleVentas;
import com.valtek.backend_database.persistence.entity.Inventario;
import com.valtek.backend_database.persistence.entity.Venta;
import com.valtek.backend_database.persistence.service.CuentasPorCobrarService;
import com.valtek.backend_database.persistence.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ventas")
public class VentaRestController {
    /* private final VentaService ventaService;
    private final CuentasPorCobrarService cuentasPorCobrarService;

    public VentaRestController(VentaService ventaService, CuentasPorCobrarService cuentasPorCobrarService) {
        this.ventaService = ventaService;
        this.cuentasPorCobrarService = cuentasPorCobrarService;
    }

    @GetMapping("/getasale")
    public List<Venta> getAllSales(){
        return ventaService.getAllSales();
    }

    @GetMapping("/getallsalesdetails")
    public List<DetalleVentas> getAllSalesDetails(Iterable<String> idVenta){
        return ventaService.showAllSalesDetails(idVenta);
    }

    @PostMapping("/saveasale")
    ResponseEntity<Venta> newSale(@RequestBody Venta sale){
        System.out.println(sale.toString());
        return new ResponseEntity<>(ventaService.saveSale(sale, null), HttpStatus.CREATED);
    }


    @PostMapping("/")
    ResponseEntity<CuentasPorCobrar> newResceivable(@RequestBody CuentasPorCobrar receivavble){
        //System.out.println(receivavble.toString());
        return new ResponseEntity<>(cuentasPorCobrarService.saveReceivable(receivavble),HttpStatus.CREATED);
    } */
}
