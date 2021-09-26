package com.valtek.backend_database.domain.repository;

import com.valtek.backend_database.persistence.entity.Usuario;
import net.bytebuddy.TypeCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

    @Query("Select u from Usuario u WHERE u.nombreUsuario = ?1 ")
    Optional<Usuario> findByusername(String nombreUsuario);

    @Query("Select u from Usuario u where u.nombreUsuario like ?1%")
    List<Usuario> findAndSort(String nombreUsuario, TypeCache.Sort Sort);

    List<Usuario> findBynombreUsuario(String nombreUsuario);

}
