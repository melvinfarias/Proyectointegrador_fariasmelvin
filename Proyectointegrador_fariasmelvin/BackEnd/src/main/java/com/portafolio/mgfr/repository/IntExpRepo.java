package com.portafolio.mgfr.repository;

import com.portafolio.mgfr.models.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IntExpRepo extends JpaRepository<Experiencia,Integer> {
    public Optional<Experiencia> findByTituloExp(String tituloExp);
    public boolean existsBytituloExp(String tituloExp);
 
}

