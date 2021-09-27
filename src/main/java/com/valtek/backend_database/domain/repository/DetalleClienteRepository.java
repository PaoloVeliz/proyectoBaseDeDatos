package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.DetalleCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleClienteRepository extends JpaRepository<DetalleCliente,Integer> {
    @Query(value = "Select ct from customer_type ct WHERE ct.id::integer = :id;", nativeQuery = true)
    Optional<DetalleCliente> findWithIntegerId(@Param("id") Integer id);

    // @Query(value = "Select ct from customer_type ct;", nativeQuery = true)
    // List<DetalleCliente> findAll();
}
