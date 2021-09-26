package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.ClienteDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import org.springframework.stereotype.Service;

@Service
public class CustomerFillUtils {
    public Cliente fillCustomer(ClienteDTO customerDto, DetalleCliente detalleCliente) {
        Cliente cliente = new Cliente();
        cliente.setNombre(customerDto.getNombre());
        cliente.setApellidos(customerDto.getApellidos());
        cliente.setCorreo(customerDto.getCorreo());
        cliente.setDireccion(customerDto.getDireccion());
        cliente.setDetalleCliente(detalleCliente);
        return cliente;
    }

    public void fillCustomerDto(Cliente customer) {

    }

    private static <T> T check(T element) {
        return element == null ? null : element;
    }
}
