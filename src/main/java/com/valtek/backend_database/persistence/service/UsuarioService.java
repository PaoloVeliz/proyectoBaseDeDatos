package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.domain.dto.RequestDTO;
import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.domain.repository.UsuarioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final Log LOG = LogFactory.getLog(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createOneUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(RequestDTO requestDTO) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(requestDTO.getUsuarioDTO().getUsername(), requestDTO.getUsuarioDTO().getPassword());
    }
}
