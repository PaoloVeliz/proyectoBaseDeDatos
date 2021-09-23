package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.DetalleVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentas,String> {
    DetalleVentas findByventasId(String ventasId);
}
