package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta,String> {

}
