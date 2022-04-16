
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.PersonaModel;
import com.ejemplo.SpringBoot.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaService{
    
    @Autowired
    PersonaRepository persoRepo;
    

    public List<PersonaModel> verPersonas() {
    return (List<PersonaModel>) persoRepo.findAll();
    }
    
    public ResponseEntity<PersonaModel> personasId(int id) {

        Optional<PersonaModel> persona = persoRepo.findById(id);

        if (persona.isPresent()) {
            return ResponseEntity.ok().body(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public PersonaModel guardar(PersonaModel persona) {
        return persoRepo.save(persona); // crea o actualiza
    }
    
    public void borrarPersona(int id){
        persoRepo.deleteById(id);
    }
    
}
