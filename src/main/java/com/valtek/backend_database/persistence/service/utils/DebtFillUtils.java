package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.CuentasPorPagarDTO;
import com.valtek.backend_database.persistence.entity.CuentasPorPagar;
import org.springframework.stereotype.Service;

@Service
public class DebtFillUtils {
    public CuentasPorPagar fillDebt(CuentasPorPagarDTO debtDTO){
        CuentasPorPagar cuentasPorPagar = new CuentasPorPagar();
        cuentasPorPagar.setTotal(debtDTO.getTotal());
        cuentasPorPagar.setFaltante(debtDTO.getFaltante());
        cuentasPorPagar.setFecha(debtDTO.getFecha());
        cuentasPorPagar.setYapagado(debtDTO.isYapagado());
        cuentasPorPagar.setComprasCodigo(debtDTO.getComprasCodigo());
        cuentasPorPagar.setProveedoresId(debtDTO.getProveedoresId());
        cuentasPorPagar.setNombre(debtDTO.getNombre());
        return cuentasPorPagar;
    }

    private static <T> T check(T element) {
        return element == null ? null : element;
    }
}
