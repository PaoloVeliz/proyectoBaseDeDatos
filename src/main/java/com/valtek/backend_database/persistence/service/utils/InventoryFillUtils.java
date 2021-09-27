package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.InventarioDTO;
import com.valtek.backend_database.persistence.entity.Inventario;
import org.springframework.stereotype.Service;

@Service
public class InventoryFillUtils {
    public Inventario fillProduct(InventarioDTO productDTO){
        Inventario inventario = new Inventario();
        inventario.setNombreProducto(productDTO.getNombreProducto());
        inventario.setCantidad(productDTO.getCantidad());
        inventario.setPrecio(productDTO.getPrecio());
        return inventario;
    }

    private static <T> T check(T element) {
        return element == null ? null : element;
    }
}
