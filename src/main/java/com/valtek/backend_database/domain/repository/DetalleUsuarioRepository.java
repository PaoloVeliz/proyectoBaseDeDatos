package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.DetalleUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleUsuarioRepository extends JpaRepository<DetalleUsuario,Integer> {

}
