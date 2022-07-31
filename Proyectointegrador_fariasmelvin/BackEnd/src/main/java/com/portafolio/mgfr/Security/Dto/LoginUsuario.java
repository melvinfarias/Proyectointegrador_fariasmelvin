
package com.portafolio.mgfr.Security.Dto;

import javax.validation.constraints.NotBlank;


public class LoginUsuario {
    @NotBlank
    private String nombreUser;
    @NotBlank
    private String password;
    
    //Getter y setter

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
