package com.portafolio.mgfr.services;

import com.portafolio.mgfr.models.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portafolio.mgfr.repository.IntEduRepo;

@Service
@Transactional
public class EduService {
    
    private final IntEduRepo intEduRepo;
    
    @Autowired
    public EduService(IntEduRepo intEduRepo) {
        this.intEduRepo = intEduRepo;
    }
    
    public Educacion addEdu(Educacion educacion) {
        return intEduRepo.save(educacion);
    }
    
    public List<Educacion> buscarEdu() {
        return intEduRepo.findAll();
    }
    
    public Educacion editarEdu(Educacion educacion) {
        return intEduRepo.save(educacion);
    }
    
    public void borrarEdu(Long id) {
        intEduRepo.deleteById(id);
    }
    
}
