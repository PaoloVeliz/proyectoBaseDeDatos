package com.valtek.backend_database.domain.controller;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.service.ClienteDetalleService;
import com.valtek.backend_database.persistence.service.ClienteService;
import com.valtek.backend_database.persistence.validate.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://base-de-datos-frontend-otz5d9zki-tatobig.vercel.app/")
@RequestMapping("/customers")
public class ClienteRestController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteDetalleService clienteDetalleService;

    @GetMapping("/")
    List<Cliente> getCustomers() {
        return clienteService.getAllCostumers();
    }

    @PostMapping("/")
    ResponseEntity<Cliente> newUser(@RequestBody RequestDTO requestDTO) throws BusinessException {
        return new ResponseEntity<>(clienteService.saveCustomer(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/type/")
    ResponseEntity<DetalleCliente> newCustomerType(@RequestBody RequestDTO requestDTO) throws Exception {
        return new ResponseEntity<>(clienteDetalleService.saveDetallCliente(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/type/")
    List<DetalleCliente> getCustomerType () {
        return clienteDetalleService.getAll();
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteCustomer(@PathVariable Integer id) throws BusinessException {
        clienteService.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/type/{id}")
    ResponseEntity deteleType(@PathVariable Integer id) throws BusinessException {
        clienteDetalleService.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}