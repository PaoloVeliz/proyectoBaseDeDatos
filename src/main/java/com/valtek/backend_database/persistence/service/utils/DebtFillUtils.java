package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.CuentasPorPagarDTO;
import com.valtek.backend_database.persistence.entity.Compra;
import com.valtek.backend_database.persistence.entity.CuentasPorPagar;
import com.valtek.backend_database.persistence.entity.Proveedores;
import org.springframework.stereotype.Service;

@Service
public class DebtFillUtils {
    public CuentasPorPagar fillDebt(CuentasPorPagarDTO debtDTO, Proveedores proveedores, Compra compra){
        CuentasPorPagar cuentasPorPagar = new CuentasPorPagar();
        cuentasPorPagar.setTotal(debtDTO.getTotal());
        cuentasPorPagar.setFecha(debtDTO.getFecha());
        cuentasPorPagar.setYapagado(debtDTO.isYapagado());
        cuentasPorPagar.setCompra(compra);
        cuentasPorPagar.setProveedores(proveedores);
        return cuentasPorPagar;
    }

    private static <T> T check(T element) {
        return element == null ? null : element;
    }
}
