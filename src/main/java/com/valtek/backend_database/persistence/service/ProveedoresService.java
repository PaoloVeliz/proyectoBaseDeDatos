package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.Proveedores;
import com.valtek.backend_database.domain.repository.ProveedoresRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private ProveedoresRepository proveedoresRepository;

    public ProveedoresService(){}

    public ProveedoresService(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    public void saveProvider(Proveedores proveedores){
        proveedoresRepository.save(proveedores);
    }

    public List<Proveedores> getAllProviders(){
        return proveedoresRepository.findAll();
    }

    public void deleteProvider(String id){
        proveedoresRepository.deleteById(id);
    }

    public Proveedores updateProvider(Proveedores newProvider, String id){
        return
                proveedoresRepository.findById(id)
                .map(
                        proveedores -> {
                            proveedores.setId(newProvider.getId());
                            proveedores.setNombres(newProvider.getNombres());
                            proveedores.setApellidos(newProvider.getApellidos());
                            proveedores.setCorreo(newProvider.getCorreo());
                            proveedores.setDireccion(newProvider.getDireccion());
                            return proveedoresRepository.save(proveedores);
                        }
                ).get();
    }
}
