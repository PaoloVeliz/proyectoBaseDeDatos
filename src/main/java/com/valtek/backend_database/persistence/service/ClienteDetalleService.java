package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.domain.repository.DetalleClienteRepository;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.service.utils.CustomerTypeFillUtils;
import com.valtek.backend_database.persistence.validate.BusinessException;
import com.valtek.backend_database.persistence.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteDetalleService {
    @Autowired
    DetalleClienteRepository detalleClienteRepository;

    @Autowired
    CustomerTypeFillUtils customerTypeFillUtils;

    public DetalleCliente saveDetallCliente (RequestDTO requestDTO) throws Exception {
        Validate.validateDetalleCliente(requestDTO);
        DetalleCliente detalleCliente = customerTypeFillUtils.fillCustomerType(requestDTO.getDetalleClienteDTO());
        return detalleClienteRepository.save(detalleCliente);
    }

    public List<DetalleCliente> getAll () {
        return detalleClienteRepository.findAll();
    }

    public void remove(Integer id) throws BusinessException {
        Optional<DetalleCliente> deleted = detalleClienteRepository.findById(id);
        if (deleted.isEmpty()) {
            throw new BusinessException("BAD_REQUEST", "El tipo de cliente no existe");
        }
        detalleClienteRepository.delete(deleted.get());
    }
}
