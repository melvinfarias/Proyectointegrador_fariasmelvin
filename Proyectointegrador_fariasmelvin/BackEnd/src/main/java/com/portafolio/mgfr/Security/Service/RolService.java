
package com.portafolio.mgfr.Security.Service;

import com.portafolio.mgfr.Security.Entity.Rol;
import com.portafolio.mgfr.Security.Enums.RolUsuario;
import com.portafolio.mgfr.Security.repository.iRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolUsuario(RolUsuario rolUsuario){
        return irolRepository.findByRolUsuario(rolUsuario);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
