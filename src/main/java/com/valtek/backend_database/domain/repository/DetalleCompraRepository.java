package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra,Integer> {

}
