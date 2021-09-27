package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.CuentasPorPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentasPorPagarRepository extends JpaRepository<CuentasPorPagar,Integer> {
}
