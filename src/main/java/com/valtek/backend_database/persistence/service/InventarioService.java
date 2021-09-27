package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Inventario;
import com.valtek.backend_database.domain.repository.InventarioRepository;
import com.valtek.backend_database.persistence.service.utils.InventoryFillUtils;
import com.valtek.backend_database.persistence.validate.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    @Autowired
    InventoryFillUtils inventoryFillUtils;


    public Inventario saveAProduct (RequestDTO requestDTO) throws Exception {
       Inventario inventario = inventoryFillUtils.fillProduct(requestDTO.getInventarioDTO());
       return inventarioRepository.save(inventario);
    }

    public List<Inventario> getAllProducts () {
        return inventarioRepository.findAll();
    }

    public Inventario updateWhenASale(Inventario newProduct, Integer newAmount){
        return
                inventarioRepository.findById(newProduct.getCodigoProducto())
                        .map(
                                inventario -> {
                                    inventario.setCodigoProducto(newProduct.getCodigoProducto());
                                    inventario.setNombreProducto(newProduct.getNombreProducto());
                                    inventario.setCantidad(newProduct.getCantidad()-newAmount);
                                    inventario.setPrecio(newProduct.getPrecio());
                                    return inventarioRepository.save(inventario);
                                }
                        ).get();
    }
    public Inventario updateWhenAPurchase(Inventario newProduct, Integer newAmount) {
        return
                inventarioRepository.findById(newProduct.getCodigoProducto())
                        .map(
                                inventario -> {
                                    inventario.setCodigoProducto(newProduct.getCodigoProducto());
                                    inventario.setNombreProducto(newProduct.getNombreProducto());
                                    inventario.setCantidad(newProduct.getCantidad() + newAmount);
                                    inventario.setPrecio(newProduct.getPrecio());
                                    return inventarioRepository.save(inventario);
                                }
                        ).get();
    }
}
