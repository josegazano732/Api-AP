
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService{
    
    @Autowired
    PersonaRepository persoRepo;
    

    public List<Persona> verPersonas() {
       return (List<Persona>) persoRepo.findAll();
    }
    
}
