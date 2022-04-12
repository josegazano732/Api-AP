
package com.ejemplo.SpringBoot.controller;

import java.util.List;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")
public class Controller {
    
    @Autowired
    private PersonaService persoServ;
    
    @GetMapping
    public List<Persona> verPersonas() {
        //return ListaPersonas;
        return persoServ.verPersonas();
    }
  
}
