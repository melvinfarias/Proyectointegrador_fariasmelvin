
package com.portafolio.mgfr.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String tituloExp;
    @NotBlank
    private String descExp;
    
    //Contructores 

    public dtoExperiencia() {
    }

    public dtoExperiencia(String tituloExp, String descExp) {
        this.tituloExp = tituloExp;
        this.descExp = descExp;
    }
    
    //Getters y Setters

    public String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }
    
    
    
}
