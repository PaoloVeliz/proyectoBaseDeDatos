package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.CompraDTO;
import com.valtek.backend_database.persistence.entity.Compra;
import com.valtek.backend_database.persistence.entity.Proveedores;
import com.valtek.backend_database.persistence.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class PurchaseFillUtils {
    public Compra fillPurchase(CompraDTO purchaseDTO, Proveedores proveedores, Usuario usuario){
        Compra compra = new Compra();
        compra.setFecha(purchaseDTO.getFecha());
        compra.setTotal(purchaseDTO.getTotal());
        compra.setYapagado(purchaseDTO.isYapagado());
        compra.setProveedores(proveedores);
        compra.setUsuario(usuario);
        return compra;
    }

    private static <T> T check(T element) {
        return element == null ? null : element;
    }
}
