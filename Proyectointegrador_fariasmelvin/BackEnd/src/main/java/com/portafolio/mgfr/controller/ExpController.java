package com.portafolio.mgfr.controller;

import com.portafolio.mgfr.Dto.dtoExperiencia;
import com.portafolio.mgfr.Security.Controller.Mensaje;
import com.portafolio.mgfr.models.Experiencia;
import com.portafolio.mgfr.services.ExpService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("explab")
@CrossOrigin(origins = "http:/localHost:4200")
public class ExpController {
    @Autowired 
    ExpService expService;
    
    @GetMapping("lista")
    public ResponseEntity<List<Experiencia>> list(){
       List<Experiencia> list = expService.list();
       return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getTituloExp()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expService.existsByTituloExp(dtoexp.getTituloExp()))
            return new ResponseEntity(new Mensaje("Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getTituloExp(),dtoexp.getDescExp());
        expService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);        
    }
    
    @PutMapping("/update{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //Validamos existencia de ID
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(expService.existsByTituloExp(dtoexp.getTituloExp()) && expService.getByTituloExp(dtoexp.getTituloExp()).get().getIdExp() !=id)
            return new ResponseEntity(new Mensaje("Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getTituloExp()))
            return new ResponseEntity(new Mensaje("El campo es obligatotio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = expService.getOne(id).get();
        experiencia.setTituloExp(dtoexp.getTituloExp());
        experiencia.setDescExp((dtoexp.getDescExp()));
        
        expService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualzada"), HttpStatus.OK);
    }
    
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos existencia de ID
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        expService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
