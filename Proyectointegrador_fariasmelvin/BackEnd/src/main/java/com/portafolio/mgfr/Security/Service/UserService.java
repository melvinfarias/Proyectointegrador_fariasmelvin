
package com.portafolio.mgfr.Security.Service;

import com.portafolio.mgfr.Security.Entity.User;
import com.portafolio.mgfr.Security.repository.iUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public Optional<User> getbyNombreUser(String nombreUser){
        return iuserRepository.findByNombreUser(nombreUser);
    }
    
   public boolean existsByNombreUser(String nombreUser){
       return iuserRepository.existsByNombreUser(nombreUser);   
   }
   
    public boolean existsByEmail(String email) {
        return iuserRepository.existsByEmail(email);
    }
    
    public void save(User user){
        iuserRepository.save(user);   
    }
}
    
        

