package com.portafolio.mgfr.services;

import com.portafolio.mgfr.models.Experiencia;
import com.portafolio.mgfr.repository.IntExpRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpService {
    private final IntExpRepo intExpRepo;
    
    @Autowired
    public ExpService(IntExpRepo intExpRepo) {
        this.intExpRepo = intExpRepo;
    }
    
    public Experiencia addExperiencia(Experiencia experiencia) {
        return intExpRepo.save(experiencia);
    }
    
    public List<Experiencia> buscarExperiencia() {
        return intExpRepo.findAll();
    }
    
    public Experiencia editarExperiencia(Experiencia experiencia) {
        return intExpRepo.save(experiencia);
    }
    
    public void borrarExperiencia(Long id) {
        intExpRepo.deleteById(id);
    }    
    
}
