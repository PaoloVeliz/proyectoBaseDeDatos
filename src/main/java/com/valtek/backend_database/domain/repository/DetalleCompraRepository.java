package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra,String> {
    DetalleCompra findBycomprasId(String comprasId);
}
