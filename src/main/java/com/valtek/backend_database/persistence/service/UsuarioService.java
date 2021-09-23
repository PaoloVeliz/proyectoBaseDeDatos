package com.valtek.backend_database.persistence.service;

import com.valtek.backend_database.persistence.entity.DetalleUsuario;
import com.valtek.backend_database.persistence.entity.Telefono;
import com.valtek.backend_database.persistence.entity.Usuario;
import com.valtek.backend_database.domain.repository.DetalleUsuarioRepository;
import com.valtek.backend_database.domain.repository.TelefonoRepository;
import com.valtek.backend_database.domain.repository.UsuarioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {
    private final Log LOG = LogFactory.getLog(UsuarioService.class);
    private UsuarioRepository usuarioRepository;
    private DetalleUsuarioRepository detalleUsuarioRepository;
    private TelefonoRepository telefonoRepository;

    public UsuarioService(){}

    public UsuarioService(UsuarioRepository usuarioRepository, DetalleUsuarioRepository detalleUsuarioRepository, TelefonoRepository telefonoRepository){
        this.usuarioRepository = usuarioRepository;
        this.detalleUsuarioRepository = detalleUsuarioRepository;
        this.telefonoRepository = telefonoRepository;
    }

    @Transactional
    public void saveAUser(Usuario usuario, DetalleUsuario detalleUsuario, List<Telefono> telefonos){
        usuarioRepository.save(usuario);
        detalleUsuarioRepository.save(detalleUsuario);
        telefonos.stream()
                .peek(telefono -> LOG.info("telefono agregado " + telefono))
                .forEach(telefono -> telefonoRepository.save(telefono));
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }
    public void deleteAUser(String id){
        usuarioRepository.deleteById(id);
        detalleUsuarioRepository.deleteById(detalleUsuarioRepository.findByusuarioId(id).getId());
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
    public DetalleUsuario updateUserDetails(DetalleUsuario newDetails, String id){
        return
                detalleUsuarioRepository.findById(detalleUsuarioRepository.findByusuarioId(id).getId())
                .map(
                        detalleUsuario -> {
                            detalleUsuario.setNombres(newDetails.getNombres());
                            detalleUsuario.setApellidos(newDetails.getApellidos());
                            detalleUsuario.setCorreo(newDetails.getCorreo());
                            detalleUsuario.setUsuarioId(newDetails.getUsuarioId());
                            detalleUsuario.setId(newDetails.getId());
                            detalleUsuario.setPosicion(newDetails.getPosicion());
                            detalleUsuario.setDireccion(newDetails.getDireccion());
                            return detalleUsuarioRepository.save(detalleUsuario);
                        }
                ).get();
    }
}
