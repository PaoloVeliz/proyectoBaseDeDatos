package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.CompraDTO;
import com.valtek.backend_database.persistence.entity.Compra;
import org.springframework.stereotype.Service;

@Service
public class PurchaseFillUtils {
    public Compra fillPurchase(CompraDTO purchaseDTO){
        Compra compra = new Compra();
        compra.setFecha(purchaseDTO.getFecha());
        compra.setTotal(purchaseDTO.getTotal());
        compra.setYapagado(purchaseDTO.isYapagado());
        compra.setProveedoresId(purchaseDTO.getProveedoresId());
        compra.setNombre(purchaseDTO.getNombre());
        return compra;
    }

    private static <T> T check(T element) {
        return element == null ? null : element;
    }
}
