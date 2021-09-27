package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.CuentasPorCobrarDTO;
import com.valtek.backend_database.persistence.entity.CuentasPorCobrar;
import org.springframework.stereotype.Service;

@Service
public class ReceivableFillUtils {
    public CuentasPorCobrar  fillReceivable(CuentasPorCobrarDTO receivableDTO){
        CuentasPorCobrar cuentasPorCobrar = new CuentasPorCobrar();
        cuentasPorCobrar.setTotal(receivableDTO.getTotal());
        cuentasPorCobrar.setFaltante(receivableDTO.getFaltante());
        cuentasPorCobrar.setFecha(receivableDTO.getFecha());
        cuentasPorCobrar.setYapagado(receivableDTO.getYapagado());
        cuentasPorCobrar.setVentasId(receivableDTO.getVentasId());
        cuentasPorCobrar.setClientesId(receivableDTO.getClientesId());
        return cuentasPorCobrar;
    }

    private static <T> T check(T element) {
        return element == null ? null : element;
    }
}
