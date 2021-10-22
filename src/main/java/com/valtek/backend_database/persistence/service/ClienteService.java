package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Telefono;
import com.valtek.backend_database.domain.repository.ClienteRepository;
import com.valtek.backend_database.domain.repository.DetalleClienteRepository;
import com.valtek.backend_database.domain.repository.TelefonoRepository;
import com.valtek.backend_database.persistence.service.utils.CustomerFillUtils;
import com.valtek.backend_database.persistence.service.utils.PhoneFillUtils;
import com.valtek.backend_database.persistence.validate.BusinessException;
import com.valtek.backend_database.persistence.validate.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DetalleClienteRepository detalleClienteRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Autowired
    private CustomerFillUtils customerFillUtils;

    @Autowired
    private PhoneFillUtils phoneFillUtils;

    @Transactional(rollbackOn = Exception.class)
    public Cliente saveCustomer(RequestDTO requestDTO) throws BusinessException {
        Validate.validateCliente(requestDTO);
        Optional<DetalleCliente> foundCustomerType = detalleClienteRepository.findById(requestDTO.getClienteDTO().getDetalleCliente_id());
        if(foundCustomerType.isEmpty()) {
            throw new BusinessException("BAD_REQUEST", "El tipo de cliente no existe");
        }
        Cliente newCustomer = customerFillUtils.fillCustomer(requestDTO.getClienteDTO(), foundCustomerType.get());
        Cliente savedCustomer = clienteRepository.save(newCustomer);

        if (requestDTO.getClienteDTO().getTelefonoDTO() != null) {
            if (requestDTO.getClienteDTO().getTelefonoDTO().size() > 0) {
                requestDTO.getClienteDTO().getTelefonoDTO().forEach(telefono -> {
                    Telefono newTelefono = phoneFillUtils.fillPhone(telefono, newCustomer);
                    telefonoRepository.save(newTelefono);
                });
            }
        }

        return savedCustomer;
    }

    /* public List<Cliente> getAllCostumers(){
        return clienteRepository.findAll();
    } */

    public List<Cliente> findPage(PageRequest pageRequest) {
        return clienteRepository.findAll(pageRequest).getContent();
    }

    public void remove(Integer id) throws BusinessException {
        Optional<Cliente> deleted = clienteRepository.findById(id);
        if (deleted.isEmpty()) {
            throw new BusinessException("BAD_REQUEST", "El cliente no existe");
        }
        clienteRepository.delete(deleted.get());
    }
}
