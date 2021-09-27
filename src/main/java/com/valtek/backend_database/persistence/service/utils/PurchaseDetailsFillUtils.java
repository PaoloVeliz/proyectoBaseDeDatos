package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.DetalleCompraDTO;
import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Compra;
import com.valtek.backend_database.persistence.entity.DetalleCompra;
import com.valtek.backend_database.persistence.entity.Inventario;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailsFillUtils {
    public DetalleCompra fillPurchaseDetail(DetalleCompraDTO detalleCompraDTO, Compra compra, Inventario producto){
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCompra(compra);
        detalleCompra.setInventario(producto);
        detalleCompra.setCantidad(detalleCompraDTO.getCantidad());
        detalleCompra.setPrecio(detalleCompraDTO.getPrecio());
        return detalleCompra;
    }
}
