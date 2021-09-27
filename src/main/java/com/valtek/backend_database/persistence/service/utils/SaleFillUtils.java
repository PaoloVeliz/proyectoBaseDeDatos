package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.persistence.entity.Venta;
import org.springframework.stereotype.Service;

@Service
public class SaleFillUtils {
    public Venta FillSale(){
        Venta venta = new Venta();

        return venta;
    }
}
