
package com.portafolio.mgfr.Security.Service;

import com.portafolio.mgfr.Security.Entity.User;
import com.portafolio.mgfr.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserdetailsImpl implements UserDetailsService{
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String nombreUser) throws UsernameNotFoundException {
        User user = userService.getbyNombreUser(nombreUser).get();
        return UsuarioPrincipal.build(user);
    }
   }

   
