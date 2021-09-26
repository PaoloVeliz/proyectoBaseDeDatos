package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.TelefonoDTO;
import com.valtek.backend_database.persistence.entity.Telefono;
import org.springframework.stereotype.Service;

@Service
public class PhoneFillUtils {
    public Telefono fillPhone(TelefonoDTO telefonoDTO) {
        Telefono telefono = new Telefono();
        telefono.setNumero(telefonoDTO.getTelefono());

        return telefono;
    }
}
