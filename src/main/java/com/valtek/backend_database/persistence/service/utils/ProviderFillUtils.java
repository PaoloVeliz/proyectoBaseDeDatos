package com.valtek.backend_database.persistence.service.utils;

import com.valtek.backend_database.domain.dto.ClienteDTO;
import com.valtek.backend_database.domain.dto.ProveedoresDTO;
import com.valtek.backend_database.persistence.entity.Cliente;
import com.valtek.backend_database.persistence.entity.DetalleCliente;
import com.valtek.backend_database.persistence.entity.Proveedores;
import org.springframework.stereotype.Service;

@Service
public class ProviderFillUtils {
    public Proveedores fillProvider(ProveedoresDTO proveedoresDTO) {
        Proveedores proveedores = new Proveedores();
        proveedores.setNombres(proveedoresDTO.getNombres());
        proveedores.setApellidos(proveedoresDTO.getApellidos());
        proveedores.setDireccion(proveedoresDTO.getDireccion());
        proveedores.setCorreo(proveedoresDTO.getEmail());
        return proveedores;
    }
}
