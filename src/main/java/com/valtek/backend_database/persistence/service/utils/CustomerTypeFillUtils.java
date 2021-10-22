package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.DetalleClienteDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeFillUtils {
    public DetalleCliente fillCustomerType(DetalleClienteDTO detalleClienteDTO) {
        DetalleCliente detalleCliente = new DetalleCliente();
        detalleCliente.setNombre(detalleClienteDTO.getNombre());
        detalleCliente.setDescuento(detalleClienteDTO.getDescuento());
        return detalleCliente;
    }

    public DetalleClienteDTO fillCustomerTypeDTO(DetalleCliente detalleCliente) {
        DetalleClienteDTO detalleClienteDTO = new DetalleClienteDTO();
        detalleClienteDTO.setDescuento(detalleCliente.getDescuento());
        detalleClienteDTO.setNombre(detalleCliente.getNombre());
        detalleClienteDTO.setId(detalleCliente.getId());
        return detalleClienteDTO;
    }
}
