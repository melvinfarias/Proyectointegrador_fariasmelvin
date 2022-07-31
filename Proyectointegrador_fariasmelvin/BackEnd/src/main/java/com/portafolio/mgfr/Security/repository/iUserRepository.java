
package com.portafolio.mgfr.Security.repository;

import com.portafolio.mgfr.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer>{
//public interface iUserRepository extends JpaRepository<User, Integer>{
    //Optional<User> FindByNombreUser(String NombreUser);
    Optional<User> findByNombreUser(String nombreUser);
    
    boolean existsByNombreUser(String nombreUser);
    boolean existsByEmail(String email);
    
    }
