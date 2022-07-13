package com.portafolio.mgfr.repository;

import com.portafolio.mgfr.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IntUsuarioRepo extends JpaRepository<Usuario,Long>{
    
}
