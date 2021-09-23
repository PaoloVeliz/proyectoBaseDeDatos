package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, String> {

}
