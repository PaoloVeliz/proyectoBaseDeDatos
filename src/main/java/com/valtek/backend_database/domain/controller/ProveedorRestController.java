package com.valtek.backend_database.domain.controller;


import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.Proveedores;
import com.valtek.backend_database.persistence.service.ProveedoresService;
import com.valtek.backend_database.persistence.validate.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://base-de-datos-frontend-14gczqhqb-tatobig.vercel.app/")
@RequestMapping("/providers")
public class ProveedorRestController {
    @Autowired
    ProveedoresService proveedoresService;

    @GetMapping("/")
    List<Proveedores> getProviders() {
        return proveedoresService.getAllProviders();
    }

    @PostMapping("/")
    ResponseEntity<Proveedores> newProvider(@RequestBody RequestDTO requestDTO) throws BusinessException {
        return new ResponseEntity<>(proveedoresService.saveProvider(requestDTO), HttpStatus.CREATED);
    }
}
