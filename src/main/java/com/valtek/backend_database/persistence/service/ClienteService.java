package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.ClienteDTO;
import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Telefono;
import com.valtek.backend_database.domain.repository.ClienteRepository;
import com.valtek.backend_database.domain.repository.DetalleClienteRepository;
import com.valtek.backend_database.domain.repository.TelefonoRepository;
import com.valtek.backend_database.persistence.service.utils.CustomerFillUtils;
import com.valtek.backend_database.persistence.service.utils.CustomerTypeFillUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public void saveASale(Cliente cliente, DetalleCliente detalleCliente, List<Telefono> telefonos){
        clienteRepository.save(cliente);
        detalleClienteRepository.save(detalleCliente);
        telefonos.stream()
                .peek(telefono -> LOG.info("telefono agregado " + telefono))
                .forEach(telefono -> telefonoRepository.save(telefono));

    }

    public void saveCustomer(RequestDTO requestDTO) {
        /* Optional<DetalleCliente> foundCustomerType = detalleClienteRepository.findById(requestDTO.getClienteDTO().getDetalleCliente_id());
        if(foundCustomerType.isEmpty()) {

        }

        Cliente newCustomer = customerFillUtils.fillCustomer(requestDTO.getClienteDTO(), foundCustomerType);
        Cliente savedCustomer = clienteRepository.save(newCustomer);

        return savedCustomer;*/
    }

    public List<Cliente> getAllCostumers(){
        return clienteRepository.findAll();
    }

    public void deleteACostumer(String id){
        clienteRepository.deleteById(id);
    }
}
