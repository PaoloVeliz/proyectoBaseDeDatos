package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.Inventario;
import com.valtek.backend_database.domain.repository.InventarioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {
    /* private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private InventarioRepository inventarioRepository;

    public InventarioService(){}

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public Inventario saveProduct(Inventario producto){
         return inventarioRepository.save(producto);
    }

    public List<Inventario> getAllProducts(){
        return inventarioRepository.findAll();
    }

    public void deleteProduct(Integer id){
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

    public int getAProductAmount(String codigoProducto){
        Optional<Inventario> producto = inventarioRepository.findById(codigoProducto);
        return producto.get().getCantidad();
    }

    public Inventario updateWhenASale(Inventario newProduct, String id){
        int previous_amount = getAProductAmount(id);
        return
                inventarioRepository.findById(id)
                .map(
                        inventario -> {
                            inventario.setCodigoProducto(newProduct.getCodigoProducto());
                            inventario.setNombreProducto(newProduct.getNombreProducto());
                            inventario.setCantidad(previous_amount - newProduct.getCantidad());
                            inventario.setPrecio(newProduct.getPrecio());
                            return inventarioRepository.save(inventario);
                        }
                ).get();
    }

    public Inventario updateWhenAPurchase(Inventario newProduct, String id){
        int previous_amount = getAProductAmount(id);
        return
                inventarioRepository.findById(id)
                        .map(
                                inventario -> {
                                    inventario.setCodigoProducto(newProduct.getCodigoProducto());
                                    inventario.setNombreProducto(newProduct.getNombreProducto());
                                    inventario.setCantidad(previous_amount - newProduct.getCantidad());
                                    inventario.setPrecio(newProduct.getPrecio());
                                    return inventarioRepository.save(inventario);
                                }
                        ).get();
    }

    public Optional<Inventario> getAProduct(String codigoProducto){
        return inventarioRepository.findById(codigoProducto);
    } */

}
