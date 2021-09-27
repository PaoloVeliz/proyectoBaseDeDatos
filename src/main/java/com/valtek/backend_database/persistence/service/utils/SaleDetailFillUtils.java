package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.DetalleCompraDTO;
import com.valtek.backend_database.domain.dto.DetalleVentasDTO;
import com.valtek.backend_database.persistence.entity.DetalleVentas;
import com.valtek.backend_database.persistence.entity.Inventario;
import com.valtek.backend_database.persistence.entity.Venta;
import org.springframework.stereotype.Service;

@Service
public class SaleDetailFillUtils {
    public DetalleVentas fillSaleDetails(DetalleVentasDTO detalleVentasDTO, Venta venta, Inventario producto){
        DetalleVentas detalleVentas = new DetalleVentas();
        detalleVentas.setVenta(venta);
        detalleVentas.setInventario(producto);
        detalleVentas.setCantidad(detalleVentasDTO.getCantidad());
        detalleVentas.setPrecio(detalleVentasDTO.getPrecio());
        return detalleVentas;
    }
}
