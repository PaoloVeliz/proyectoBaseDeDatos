package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.ClienteDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Telefono;
import com.valtek.backend_database.domain.repository.ClienteRepository;
import com.valtek.backend_database.domain.repository.DetalleClienteRepository;
import com.valtek.backend_database.domain.repository.TelefonoRepository;
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
    private CustomerTypeFillUtils customerTypeFillUtils;

    @Transactional
    public void saveASale(Cliente cliente, DetalleCliente detalleCliente, List<Telefono> telefonos){
        clienteRepository.save(cliente);
        detalleClienteRepository.save(detalleCliente);
        telefonos.stream()
                .peek(telefono -> LOG.info("telefono agregado " + telefono))
                .forEach(telefono -> telefonoRepository.save(telefono));

    }

    public void saveCustomer(ClienteDTO customerDto) {
        /* DetalleCliente detalleCliente = customerTypeFillUtils.fillCustomerType(customerDto.getDetalleClienteDTO());
        Optional<DetalleCliente> foundCustomerType = detalleClienteRepository.findById(detalleCliente.getId());

        if(foundCustomerType.isEmpty()) {

        }

        detalleClienteRepository.save(detalleCliente);

        Cliente cliente = new Cliente(
                customer.getNombre(),
                customer.getApellidos(),
                customer.getCorreo(),
                customer.getDireccion(),
                detalleCliente.getId()
        );
        Cliente savedCustomer = clienteRepository.save(cliente);
        if (customer.getTelefonos().size() > 0) {
            System.out.println(customer.getTelefonos());
            customer.getTelefonos().forEach(phone -> {
                Telefono newPhone = new Telefono(phone.getNumero(), savedCustomer.getId());
                telefonoRepository.save(newPhone);
            });
        }
        return savedCustomer; */
    }

    public List<Cliente> getAllCostumers(){
        return clienteRepository.findAll();
    }

    public void deleteACostumer(String id){
        clienteRepository.deleteById(id);
    }
}
