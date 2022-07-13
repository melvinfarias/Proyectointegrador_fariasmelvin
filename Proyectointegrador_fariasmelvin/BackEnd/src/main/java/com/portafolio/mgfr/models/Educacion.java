package com.portafolio.mgfr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
 private Long idEdu;
 private String tituloEdu;
 private String fechaEdu;
 private String descEdu;
 
}
  
