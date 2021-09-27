package com.valtek.backend_database.persistence.validate;

import com.valtek.backend_database.domain.dto.RequestDTO;

public class Validate {

    public static void validateDetalleCliente(RequestDTO requestDTO) throws Exception {
        if (requestDTO.getDetalleClienteDTO().getDescuento() == null) {
            throw new BusinessException("BAD_REQUEST", "La cantidad de descuento es necesaria");
        }
        if (requestDTO.getDetalleClienteDTO().getNombre() == null) {
            throw new BusinessException("BAD_REQUEST", "Es necesario asignarle un nombre al tipo");
        }
    }

    public static void validateCliente(RequestDTO requestDTO) throws BusinessException {
        if (requestDTO.getClienteDTO().getNombre() == null) {
            throw new BusinessException("BAD_REQUEST", "Es necesario asignar un nombre de cliente");
        }
        if (requestDTO.getClienteDTO().getDetalleCliente_id() == null) {
            throw new BusinessException("BAD_REQUEST", "Es necesario asignar un tipo de cliente");
        }
    }
}
