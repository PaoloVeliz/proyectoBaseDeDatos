package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.Inventario;
import com.valtek.backend_database.domain.repository.InventarioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private InventarioRepository inventarioRepository;

    public InventarioService(){}

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public void saveProduct(Inventario producto){
        inventarioRepository.save(producto);
    }

    public List<Inventario> getAllProducts(){
        return inventarioRepository.findAll();
    }

    public void deleteProduct(String id){
        inventarioRepository.deleteById(id);
    }

    public Inventario updateProduct(Inventario newProduct, String id){
        return
                inventarioRepository.findById(id)
                .map(
                        inventario -> {
                            inventario.setCodigoProducto(newProduct.getCodigoProducto());
                            inventario.setNombreProducto(newProduct.getNombreProducto());
                            inventario.setCantidad(newProduct.getCantidad());
                            inventario.setPrecio(newProduct.getPrecio());
                            return inventarioRepository.save(inventario);
                        }
                ).get();
    }


}
