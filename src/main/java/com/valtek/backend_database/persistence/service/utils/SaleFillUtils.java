package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.VentaDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.persistence.entity.Venta;
import org.springframework.stereotype.Service;

@Service
public class SaleFillUtils {
    /*
     public Compra fillPurchase(CompraDTO purchaseDTO, Proveedores proveedores, Usuario usuario){
        Compra compra = new Compra();
        compra.setFecha(purchaseDTO.getFecha());
        compra.setTotal(purchaseDTO.getTotal());
        compra.setYapagado(purchaseDTO.isYapagado());
        compra.setProveedores(proveedores);
        compra.setUsuario(usuario);
        return compra;
    }
     */
    public Venta FillSale(VentaDTO saleDTO, Cliente cliente, Usuario usuario){
        Venta venta = new Venta();
            venta.setFecha(saleDTO.getFecha());
            venta.setTotal(saleDTO.getTotal());
            venta.setYapagado(saleDTO.isYapagado());
            venta.setCliente(cliente);
            venta.setUsuario(usuario);
        return venta;
    }
}
