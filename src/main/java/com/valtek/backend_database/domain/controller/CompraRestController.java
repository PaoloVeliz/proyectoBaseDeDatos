package com.valtek.backend_database.domain.controller;


import com.valtek.backend_database.persistence.entity.Compra;
import com.valtek.backend_database.persistence.entity.CuentasPorPagar;
import com.valtek.backend_database.persistence.entity.DetalleCompra;
import com.valtek.backend_database.persistence.service.CompraService;
import com.valtek.backend_database.persistence.service.CuentasPorPagarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/compras")
public class CompraRestController {
    /*private final CompraService compraService;
    private final CuentasPorPagarService cuentasPorPagarService;

    public CompraRestController(CompraService compraService, CuentasPorPagarService cuentasPorPagarService) {
        this.compraService = compraService;
        this.cuentasPorPagarService = cuentasPorPagarService;
    }

    @GetMapping("/getallpurchases")
    List<Compra> getAllPurchases() {
        return compraService.getAllPurchases();
    }

    @GetMapping("/showalldetails")
    List<DetalleCompra> showAllPurchasesDetails(String idPurhcase){
        return compraService.showPurchaseDetails(idPurhcase);
    }

    @PostMapping("/")
    ResponseEntity<Compra> newPurchase(@RequestBody Compra purchase){
        System.out.println(purchase.toString());
        return new ResponseEntity<>(compraService.saveAPurchase(purchase,null), HttpStatus.CREATED);
    }
*/

}
