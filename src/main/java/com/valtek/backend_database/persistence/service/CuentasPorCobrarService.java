package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.CuentasPorCobrar;
import com.valtek.backend_database.domain.repository.CuentasPorCobrarRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CuentasPorCobrarService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private CuentasPorCobrarRepository cuentasPorCobrarRepository;

    @Transactional
    public CuentasPorCobrar saveReceivable(CuentasPorCobrar cuentasPorCobrar){
       return cuentasPorCobrarRepository.save(cuentasPorCobrar);
    }

    public List<CuentasPorCobrar> getAllReceivables(){
        return cuentasPorCobrarRepository.findAll();
    }

    public void deleteReceivable(String id){
        cuentasPorCobrarRepository.deleteById(id);
    }

    public CuentasPorCobrar updateReceivable(CuentasPorCobrar newReceivable, String id){
        return
                cuentasPorCobrarRepository.findById(id)
                .map(
                        cuentasPorCobrar -> {
                            cuentasPorCobrar.setId(newReceivable.getId());
                            cuentasPorCobrar.setClientesId(newReceivable.getClientesId());
                            cuentasPorCobrar.setFaltante(newReceivable.getFaltante());
                            cuentasPorCobrar.setFecha(newReceivable.getFecha());
                            cuentasPorCobrar.setVentasId(newReceivable.getVentasId());
                            cuentasPorCobrar.setYapagado(newReceivable.isYapagado());
                            cuentasPorCobrar.setTotal(newReceivable.getTotal());
                            return cuentasPorCobrarRepository.save(cuentasPorCobrar);
                        }
                ).get();
    }

}
