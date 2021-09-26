package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.Compra;
import com.valtek.backend_database.persistence.entity.DetalleCompra;
import com.valtek.backend_database.domain.repository.CompraRepository;
import com.valtek.backend_database.domain.repository.DetalleCompraRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private CompraRepository compraRepository;
    private DetalleCompraRepository detalleCompraRepository;

    public CompraService(){}
    public CompraService(CompraRepository compraRepository, DetalleCompraRepository detalleCompraRepository) {
        this.compraRepository = compraRepository;
        this.detalleCompraRepository = detalleCompraRepository;
    }

    @Transactional
    public Compra saveAPurchase(Compra compra, List<DetalleCompra> detalleCompras){
       Compra newPurchase = new Compra();
       newPurchase = compraRepository.save(compra);
        detalleCompras.stream()
                .peek(detalleCompra -> LOG.info("detalle de la compra ingresada "))
                .forEach(detalleCompra -> detalleCompraRepository.save(detalleCompra));
        return newPurchase;
    }

    public List<Compra> getAllPurchases(){
        return compraRepository.findAll();
    }
    @Transactional
    public void deleteAPurchase(String id){
        compraRepository.deleteById(id);

        detalleCompraRepository.findBycomprasId(id).stream()
                .peek(detalleCompra -> LOG.info(("detalle borrado")))
                .forEach(detalleCompra -> detalleCompraRepository.deleteById(detalleCompra.getComprasId()));
        //detalleCompraRepository.deleteById(detalleCompraRepository.findBycomprasId(id));
    }

    public List<DetalleCompra> showPurchaseDetails (String idCompra){
        return detalleCompraRepository.findBycomprasId(idCompra);
    }
    public Compra updatePurchase(Compra newPurhcase , String id){
        return
                compraRepository.findById(id)
                .map(
                        compra -> {
                            compra.setId(newPurhcase.getId());
                            compra.setFecha(newPurhcase.getFecha());
                            compra.setNombre(newPurhcase.getNombre());
                            compra.setTotal(newPurhcase.getTotal());
                            compra.setYapagado(newPurhcase.isYapagado());
                            compra.setProveedoresId(newPurhcase.getProveedoresId());
                            return compraRepository.save(compra);
                        }
                ).get();
    }
}
