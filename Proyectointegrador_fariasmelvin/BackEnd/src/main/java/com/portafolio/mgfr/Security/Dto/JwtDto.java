
package com.portafolio.mgfr.Security.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String nombreUser;
    private Collection<? extends GrantedAuthority> authorities;
    
    //Constructor

    public JwtDto(String token, String nombreUser, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUser = nombreUser;
        this.authorities = authorities;
    }

    
    
    //Getter y Setter

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
    
    
}
