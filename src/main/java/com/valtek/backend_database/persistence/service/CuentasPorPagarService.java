package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.CuentasPorPagar;
import com.valtek.backend_database.domain.repository.CuentasPorPagarRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentasPorPagarService {
    /* private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private CuentasPorPagarRepository cuentasPorPagarRepository;

    public CuentasPorPagarService(){}

    public CuentasPorPagarService(CuentasPorPagarRepository cuentasPorPagarRepository) {
        this.cuentasPorPagarRepository = cuentasPorPagarRepository;
    }

    public void saveDebt(CuentasPorPagar cuentasPorPagar){
        cuentasPorPagarRepository.save(cuentasPorPagar);
    }

    public List<CuentasPorPagar> getAllDebts(){
        return cuentasPorPagarRepository.findAll();
    }

    public void deleteDebt(String id){
        cuentasPorPagarRepository.deleteById(id);
    }

    public CuentasPorPagar updateDebt(CuentasPorPagar newDebt, String id){
        return
                cuentasPorPagarRepository.findById(id)
                .map(
                        cuentasPorPagar -> {
                            cuentasPorPagar.setId(newDebt.getId());
                            cuentasPorPagar.setComprasCodigo(newDebt.getComprasCodigo());
                            cuentasPorPagar.setFaltante(newDebt.getFaltante());
                            cuentasPorPagar.setNombre(newDebt.getNombre());
                            cuentasPorPagar.setYapagado(newDebt.isYapagado());
                            cuentasPorPagar.setFecha(newDebt.getFecha());
                            cuentasPorPagar.setProveedoresId(newDebt.getProveedoresId());
                            cuentasPorPagar.setTotal(newDebt.getTotal());
                            return cuentasPorPagarRepository.save(cuentasPorPagar);
                        }
                ).get();
    } */
}
