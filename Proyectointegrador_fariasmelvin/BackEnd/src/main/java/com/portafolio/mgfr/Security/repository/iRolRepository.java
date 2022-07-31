
package com.portafolio.mgfr.Security.repository;

import com.portafolio.mgfr.Security.Entity.Rol;
import com.portafolio.mgfr.Security.Enums.RolUsuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolUsuario(RolUsuario rolUsuario);  
}
