
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.SoftskillModel;
import com.ejemplo.SpringBoot.repository.SoftskillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author JLG
 */
@Service
public class SoftskillService {
    
    @Autowired
    SoftskillRepository softRepo;
    
 // Busca todo los skill   
 public List<SoftskillModel> verSkill() {
    return (List<SoftskillModel>) softRepo.findAll();
    }
 //busca skill por su ID
 public ResponseEntity<SoftskillModel> skillId(long id) {

        Optional<SoftskillModel> skill = softRepo.findById(id);

        if (skill.isPresent()) {
            return ResponseEntity.ok().body(skill.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
 // Crea o actualiza 
 public SoftskillModel guardar(SoftskillModel skill) {
        return softRepo.save(skill); 
    }
    
 // Borra Skill por su ID
    public void borrarSkill(long id){
        softRepo.deleteById(id);
    }
    
}
