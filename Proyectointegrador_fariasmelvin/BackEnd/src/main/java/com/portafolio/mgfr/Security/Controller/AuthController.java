
package com.portafolio.mgfr.Security.Controller;

import com.portafolio.mgfr.Security.Dto.JwtDto;
import com.portafolio.mgfr.Security.Dto.LoginUsuario;
import com.portafolio.mgfr.Security.Dto.NuevoUsuario;
import com.portafolio.mgfr.Security.Entity.Rol;
import com.portafolio.mgfr.Security.Entity.User;
import com.portafolio.mgfr.Security.Enums.RolUsuario;
import com.portafolio.mgfr.Security.Service.RolService;
import com.portafolio.mgfr.Security.Service.UserService;
import com.portafolio.mgfr.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UserService userService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en campos o email invalido"),HttpStatus.BAD_REQUEST);
        
        if(userService.existsByNombreUser(nuevoUsuario.getNombreUser()))
            return new ResponseEntity(new Mensaje("Nombre de usuario existente"), HttpStatus.BAD_REQUEST);
        
        if(userService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email ya existe"), HttpStatus.BAD_REQUEST);
        
        User user = new User(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUser(),
            nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolUsuario(RolUsuario.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolUsuario(RolUsuario.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        
        return new ResponseEntity(new Mensaje("Usuario guardado con exito"), HttpStatus.CREATED);
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje ("Campos invalidos por favor verifique"),HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.
                getNombreUser(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
        
    }
}
