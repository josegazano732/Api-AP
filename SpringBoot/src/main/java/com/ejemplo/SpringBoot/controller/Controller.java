
package com.ejemplo.SpringBoot.controller;

import java.util.List;

import com.ejemplo.SpringBoot.model.PersonaModel;
import com.ejemplo.SpringBoot.service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")
public class Controller {
    
    @Autowired
    private PersonaService persoServ;
    
    @GetMapping
    public List<PersonaModel> verPersonas() {
        //return ListaPersonas;
        return persoServ.verPersonas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> PersonasId(@PathVariable(value = "id") int id) {
        return persoServ.personasId(id);
    }
    
    @PostMapping("/nueva")
    public PersonaModel nuevaPersona(@Validated @RequestBody PersonaModel persona) {
        return persoServ.guardar(persona);
    }
    
    @PutMapping("/actualizar/{id}") //put facil
    public PersonaModel actualizarPersona(@Validated @RequestBody PersonaModel persona) {
        return persoServ.guardar(persona);
    }


    @PutMapping("/modificar/{id}") //put dificil
    public ResponseEntity<PersonaModel> actualizarPersDificil(@PathVariable(value = "id") int id, @Validated @RequestBody PersonaModel persona) {
        if (id == persona.id()) {
            PersonaModel personaNueva = persoServ.guardar(persona);
            return ResponseEntity.ok().body(personaNueva);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("borrar/{id}")
    public void borrarPersona(@PathVariable int id){
        persoServ.borrarPersona(id);
    }

    }
