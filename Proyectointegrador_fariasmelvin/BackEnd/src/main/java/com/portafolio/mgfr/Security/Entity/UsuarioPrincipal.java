
package com.portafolio.mgfr.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;





public class UsuarioPrincipal implements UserDetails{
    private String nombre;
    private String nombreUser;
    //private String nombreUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    
    //Constructor 
    public UsuarioPrincipal(String nombre, String nombreUser, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUser = nombreUser;
        //this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static UsuarioPrincipal build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolUsuario().name())).collect(Collectors.toList());
        return new UsuarioPrincipal( user.getNombre(), user.getNombreUser(), user.getEmail(), user.getPassword(), authorities);      
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;  
    }

    @Override
    public String getPassword() {
        return password;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nombreUser;
        //return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
