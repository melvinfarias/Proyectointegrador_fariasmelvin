package com.portafolio.mgfr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
 private Long idProyecto;
 private String titProyecto;
 private String fechaProyecto;
 private String descProyecto;
  
}
