package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.CuentasPorPagar;
import com.valtek.backend_database.persistence.entity.DetalleVentas;
import com.valtek.backend_database.persistence.entity.Venta;
import com.valtek.backend_database.domain.repository.DetalleVentasRepository;
import com.valtek.backend_database.domain.repository.VentaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VentaService {
    /* private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private VentaRepository ventaRepository;
    private DetalleVentasRepository detalleVentasRepository;

    public VentaService(){}

    public VentaService(VentaRepository ventaRepository, DetalleVentasRepository detalleVentasRepository) {
        this.ventaRepository = ventaRepository;
        this.detalleVentasRepository = detalleVentasRepository;
    }

    @Transactional
    public Venta saveSale(Venta venta, List<DetalleVentas> detalleVentas){
        Venta newSale = new Venta();
        newSale = ventaRepository.save(venta);
        detalleVentas.stream()
                .peek(detalleVentas1 -> LOG.info("detalle de venta ingresado "+ detalleVentas1))
                .forEach(detalleVentas1 -> detalleVentasRepository.save(detalleVentas1));
        return newSale;
    }

    public List<Venta> getAllSales(){
       return ventaRepository.findAll();
    }

    public void deleteSale(String id){
        ventaRepository.deleteById(id);
        detalleVentasRepository.deleteById(detalleVentasRepository.findByventasId(id).getId());
    }

    public Venta updateSale(Venta newSale, String id) {
        return
                ventaRepository.findById(id)
                .map(
                        venta -> {
                            venta.setId(newSale.getId());
                            venta.setFecha(newSale.getFecha());
                            venta.setTotal(newSale.getTotal());
                            venta.setYapagado(newSale.isYapagado());
                            venta.setClientesId(newSale.getClientesId());
                            venta.setNombre(newSale.getNombre());
                            venta.setUsuarioId(newSale.getUsuarioId());
                            return ventaRepository.save(venta);
                        }
                ).get();
    }

    public List<DetalleVentas> showAllSalesDetails(Iterable<String> idVenta){
        return detalleVentasRepository.findAllById(idVenta);
    } */
}
