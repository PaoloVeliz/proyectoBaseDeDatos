package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Telefono;
import com.valtek.backend_database.domain.repository.ClienteRepository;
import com.valtek.backend_database.domain.repository.DetalleClienteRepository;
import com.valtek.backend_database.domain.repository.TelefonoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private ClienteRepository clienteRepository;
    private DetalleClienteRepository detalleClienteRepository;
    private TelefonoRepository telefonoRepository;

    public ClienteService(){}

    public ClienteService(ClienteRepository clienteRepository, DetalleClienteRepository detalleClienteRepository, TelefonoRepository telefonoRepository) {
        this.clienteRepository = clienteRepository;
        this.detalleClienteRepository = detalleClienteRepository;
        this.telefonoRepository = telefonoRepository;
    }

    @Transactional
    public void saveASale(Cliente cliente, DetalleCliente detalleCliente, List<Telefono> telefonos){
        clienteRepository.save(cliente);
        detalleClienteRepository.save(detalleCliente);
        telefonos.stream()
                .peek(telefono -> LOG.info("telefono agregado " + telefono))
                .forEach(telefono -> telefonoRepository.save(telefono));

    }

    public List<Cliente> getAllCostumers(){
        return clienteRepository.findAll();
    }

    public void deleteACostumer(String id){
        clienteRepository.deleteById(id);
    }
    public Cliente updateCostumer(Cliente newCostumer,String id){
        return
                clienteRepository.findById(id)
                .map(
                        cliente -> {
                            cliente.setId(newCostumer.getId());
                            cliente.setNombre(newCostumer.getNombre());
                            cliente.setApellidos(newCostumer.getApellidos());
                            cliente.setCorreo(newCostumer.getCorreo());
                            cliente.setDetalleclientesId(newCostumer.getDetalleclientesId());
                            cliente.setDireccion(newCostumer.getDireccion());
                            return clienteRepository.save(cliente);
                        }
                ).get();
    }

    public DetalleCliente updateCostumerDetails(DetalleCliente newDetalleCliente, String id){
        return
                detalleClienteRepository.findById(id)
                .map(
                        detalleCliente -> {
                            detalleCliente.setId(newDetalleCliente.getId());
                            detalleCliente.setTipo(newDetalleCliente.getTipo());
                            detalleCliente.setDescuento(newDetalleCliente.getDescuento());
                            return detalleClienteRepository.save(detalleCliente);
                        }
                ).get();
    }
}
