package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.DetalleUsuario;
import com.valtek.backend_database.persistence.entity.Telefono;
import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.domain.repository.DetalleUsuarioRepository;
import com.valtek.backend_database.domain.repository.TelefonoRepository;
import com.valtek.backend_database.domain.repository.UsuarioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    private final Log LOG = LogFactory.getLog(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    private DetalleUsuarioRepository detalleUsuarioRepository;
    private TelefonoRepository telefonoRepository;


    @Transactional
    public Usuario saveAUser(Usuario usuario, DetalleUsuario detalleUsuario, List<Telefono> telefonos){

        detalleUsuarioRepository.save(detalleUsuario);
        telefonos.stream()
                .peek(telefono -> LOG.info("telefono agregado " + telefono))
                .forEach(telefono -> telefonoRepository.save(telefono));
        return usuarioRepository.save(usuario);
    }

    public Usuario createOneUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }
    public void deleteAUser(String id){
        usuarioRepository.deleteById(id);
    }

    public Usuario updatePassword(Usuario newUser, String id){
        return
                usuarioRepository.findById(id)
                .map(
                        usuario -> {
                            usuario.setNombreUsuario(newUser.getNombreUsuario());
                            usuario.setContrasena(newUser.getContrasena());
                            return usuarioRepository.save(usuario);
                        }
                ).get();
    }

}
