package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.domain.repository.*;
import com.valtek.backend_database.persistence.entity.*;
import com.valtek.backend_database.persistence.service.utils.PurchaseDetailsFillUtils;
import com.valtek.backend_database.persistence.service.utils.PurchaseFillUtils;
import com.valtek.backend_database.persistence.service.utils.SaleDetailFillUtils;
import com.valtek.backend_database.persistence.service.utils.SaleFillUtils;
import com.valtek.backend_database.persistence.validate.BusinessException;
import com.valtek.backend_database.persistence.validate.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private DetalleVentasRepository detalleVentasRepository;

    @Autowired
    private SaleFillUtils saleFillUtils;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private SaleDetailFillUtils saleDetailFillUtils;

    @Transactional(rollbackOn = Exception.class)
    public Venta saveSale(RequestDTO requestDTO) throws BusinessException {
        Validate.validateVenta(requestDTO);
        Optional<Cliente> foundCostumer = clienteRepository.findById(requestDTO.getVentaDTO().getClienteId());
        if(foundCostumer.isEmpty()) {
            throw new BusinessException("BAD_REQUEST", "El cliente no existe");
        }
        Optional<Usuario> foundUser = usuarioRepository.findById(requestDTO.getVentaDTO().getUsuarioId());
        if(foundUser.isEmpty()) {
            throw new BusinessException("BAD_REQUEST", "El usuario no existe");
        }
        Venta newSale = saleFillUtils.FillSale(requestDTO.getVentaDTO(),foundCostumer.get(), foundUser.get());
        Venta savedSale = ventaRepository.save(newSale);

        if (requestDTO.getVentaDTO().getDetalleVentasDTO().size() > 0) {
            requestDTO.getVentaDTO().getDetalleVentasDTO().forEach(detalleVentasDTO -> {
                Optional<Inventario> foundProduct = inventarioRepository.findById(detalleVentasDTO.getProductoId());
                if(foundProduct.isEmpty()) {
                    try {
                        throw new BusinessException("BAD_REQUEST", "El producto no existe");
                    } catch (BusinessException e) {
                        e.printStackTrace();
                    }
                }
                DetalleVentas newDetalleVenta = saleDetailFillUtils.fillSaleDetails(detalleVentasDTO,newSale,foundProduct.get());
                detalleVentasRepository.save(newDetalleVenta);
                try {
                    Validate.validateAnAmountChange(newDetalleVenta,foundProduct.get());
                } catch (BusinessException e) {
                    e.printStackTrace();
                }
                inventarioService.updateWhenASale(foundProduct.get(),newDetalleVenta.getCantidad());
            });
        }

        return savedSale;
    }

    public List<Venta> getAllSales(){
        return ventaRepository.findAll();
    }













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
