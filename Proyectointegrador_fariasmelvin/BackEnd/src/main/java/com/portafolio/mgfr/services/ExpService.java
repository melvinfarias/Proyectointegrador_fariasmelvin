package com.portafolio.mgfr.services;

import com.portafolio.mgfr.models.Experiencia;
import com.portafolio.mgfr.repository.IntExpRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ExpService {

    @Autowired
    IntExpRepo intExpRepo;
    
    public List<Experiencia> list() {
        return intExpRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return intExpRepo.findById(id);
    }
    
    public Optional<Experiencia> getByTituloExp(String tituloExp){
        return intExpRepo.findByTituloExp(tituloExp);
        
    }
    
    public void save(Experiencia expe){
      intExpRepo.save(expe);
    }
    
    public void delete(int id){
        intExpRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return intExpRepo.existsById(id);
    }
    
    public boolean existsByTituloExp(String tituloExp){
        return intExpRepo.existsBytituloExp(tituloExp);
    }
     
}
