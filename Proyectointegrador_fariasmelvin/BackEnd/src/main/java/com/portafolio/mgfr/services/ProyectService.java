package com.portafolio.mgfr.services;

import com.portafolio.mgfr.models.Proyectos;
import com.portafolio.mgfr.repository.IntProyectRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProyectService {
    private final IntProyectRepo intProyectRepo;
    
    @Autowired
    public ProyectService(IntProyectRepo intProyectRepo) {
        this.intProyectRepo = intProyectRepo;
    }
    
    public Proyectos addProyectos(Proyectos proyectos) {
        return intProyectRepo.save(proyectos);
    }
    
    public List<Proyectos> buscarProyectos() {
        return intProyectRepo.findAll();
    }
    
    public Proyectos editarProyectos(Proyectos proyectos) {
        return intProyectRepo.save(proyectos);
    }
    
    public void borrarProyectos(Long id) {
        intProyectRepo.deleteById(id);
    }    
    
}
