package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.domain.repository.*;
import com.valtek.backend_database.persistence.entity.*;
import com.valtek.backend_database.persistence.service.utils.CustomerFillUtils;
import com.valtek.backend_database.persistence.service.utils.PhoneFillUtils;
import com.valtek.backend_database.persistence.service.utils.PurchaseDetailsFillUtils;
import com.valtek.backend_database.persistence.service.utils.PurchaseFillUtils;
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
public class CompraService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private PurchaseFillUtils purchaseFillUtils;

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private PurchaseDetailsFillUtils purchaseDetailsFillUtils;

    @Transactional
    public Compra savePurchase(RequestDTO requestDTO) throws BusinessException {
        Validate.validateCompra(requestDTO);
        Optional<Proveedores> foundProvider = proveedoresRepository.findById(requestDTO.getCompraDTO().getProveedoresId());
        if(foundProvider.isEmpty()) {
            throw new BusinessException("BAD_REQUEST", "El proveedor no existe");
        }
        Optional<Usuario> foundUser = usuarioRepository.findById(requestDTO.getCompraDTO().getUsuarioId());
        if(foundUser.isEmpty()) {
            throw new BusinessException("BAD_REQUEST", "El usuario no existe");
        }

        Compra newPurchase = purchaseFillUtils.fillPurchase(requestDTO.getCompraDTO(),foundProvider.get(),foundUser.get());
        Compra savedPurchase = compraRepository.save(newPurchase);

        if (requestDTO.getCompraDTO().getDetalleCompraDTO().size() > 0) {
            requestDTO.getCompraDTO().getDetalleCompraDTO().forEach(detalleCompraDTO -> {
                Optional<Inventario> foundProduct = inventarioRepository.findById(detalleCompraDTO.getProductoId());
                if(foundProduct.isEmpty()) {
                    try {
                        throw new BusinessException("BAD_REQUEST", "El producto no existe");
                    } catch (BusinessException e) {
                        e.printStackTrace();
                    }
                }
                DetalleCompra newDetalleCompra = purchaseDetailsFillUtils.fillPurchaseDetail(detalleCompraDTO,newPurchase,foundProduct.get());
                detalleCompraRepository.save(newDetalleCompra);
            });
        }

        return savedPurchase;
    }

    public List<Compra> getAllPurchases(){
        return compraRepository.findAll();
    }

}
