package com.portafolio.mgfr.repository;

import com.portafolio.mgfr.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IntExpRepo extends JpaRepository<Experiencia,Long> {
    
}
