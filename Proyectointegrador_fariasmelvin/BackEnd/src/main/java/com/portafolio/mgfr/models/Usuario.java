package com.portafolio.mgfr.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idUsuario;
    private String nomUsuario;
    private String apellUsuario;
    private String titUsuario;
    private String descUsuario;
    private String fotPerfUsuario;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idEdu")
    private List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idExp")
    private List<Experiencia> experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idSkill")
    private List<Skills> SkillList;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idProyecto")
    private List<Proyectos> proyectoList;
              
    
}
