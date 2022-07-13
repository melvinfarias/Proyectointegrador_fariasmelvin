package com.portafolio.mgfr.services;

import com.portafolio.mgfr.models.Skills;
import com.portafolio.mgfr.repository.IntSkillsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
     private final IntSkillsRepo intSkillsRepo;
    
    @Autowired
    public SkillsService(IntSkillsRepo intSkillsRepo) {
        this.intSkillsRepo = intSkillsRepo;
    }
    
    public Skills addSkills(Skills skills) {
        return intSkillsRepo.save(skills);
    }
    
    public List<Skills> buscarSkills() {
        return intSkillsRepo.findAll();
    }
    
    public Skills editarSkills(Skills skills) {
        return intSkillsRepo.save(skills);
    }
    
    public void borrarSkills(Long id) {
        intSkillsRepo.deleteById(id);
    }    
}
