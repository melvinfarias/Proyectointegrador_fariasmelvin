package com.portafolio.mgfr.repository;

import com.portafolio.mgfr.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IntSkillsRepo extends JpaRepository<Skills,Long> {
    
}
