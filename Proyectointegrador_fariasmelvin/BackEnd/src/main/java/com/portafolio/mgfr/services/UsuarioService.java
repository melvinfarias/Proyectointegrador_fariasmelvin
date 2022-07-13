package com.portafolio.mgfr.services;

import com.portafolio.mgfr.exception.UserNotFoundException;
import com.portafolio.mgfr.models.Usuario;
import com.portafolio.mgfr.repository.IntUsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsuarioService {
    private final IntUsuarioRepo intUsuarioRepo;
    
    @Autowired
    public UsuarioService(IntUsuarioRepo intUsuarioRepo) {
        this.intUsuarioRepo = intUsuarioRepo;
    }
    
    public Usuario addUsuario(Usuario usuario) {
        return intUsuarioRepo.save(usuario);
    }
    
    public List<Usuario> buscarUsuario() {
        return intUsuarioRepo.findAll();
    }
    
    public Usuario editarUsuario(Usuario usuario) {
        return intUsuarioRepo.save(usuario);
    }
    
    public void borrarUsuario(Long id) {
        intUsuarioRepo.deleteById(id);
    }
    
    public Usuario buscarUsuarioPorId(Long id) {
        return intUsuarioRepo.findById(id).orElseThrow(()->new UserNotFoundException("Usuario no encontrado"));
        
    }

}

