package com.portafolio.mgfr.repository;

import com.portafolio.mgfr.models.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IntEduRepo extends JpaRepository<Educacion,Long> {
    
}
