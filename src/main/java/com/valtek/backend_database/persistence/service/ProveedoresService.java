package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Proveedores;
import com.valtek.backend_database.domain.repository.ProveedoresRepository;
import com.valtek.backend_database.persistence.entity.Telefono;
import com.valtek.backend_database.persistence.service.utils.ProviderFillUtils;
import com.valtek.backend_database.persistence.validate.BusinessException;
import com.valtek.backend_database.persistence.validate.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService {
    @Autowired
    ProveedoresRepository proveedoresRepository;

    @Autowired
    ProviderFillUtils providerFillUtils;

    public List<Proveedores> getAllProviders(){
        return proveedoresRepository.findAll();
    }

    public Proveedores saveProvider (RequestDTO requestDTO) throws BusinessException {
        Validate.validateProveedor(requestDTO);
        Proveedores proveedores = providerFillUtils.fillProvider(requestDTO.getProveedoresDTO());
        return proveedoresRepository.save(proveedores);
    }
}
