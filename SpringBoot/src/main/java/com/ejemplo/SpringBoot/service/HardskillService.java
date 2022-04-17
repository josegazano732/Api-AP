
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.HardskillModel;
import com.ejemplo.SpringBoot.repository.HardskillRepository;
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
public class HardskillService {
    
    @Autowired
    HardskillRepository hardRepo;
    
    // Busca todo los skill   
 public List<HardskillModel> verSkill() {
    return (List<HardskillModel>) hardRepo.findAll();
    }
 
 //busca skill por su ID
 public ResponseEntity<HardskillModel> skillId(long id) {

        Optional<HardskillModel> skill = hardRepo.findById(id);

        if (skill.isPresent()) {
            return ResponseEntity.ok().body(skill.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
 // Crea o actualiza 
 public HardskillModel guardar(HardskillModel skill) {
        return hardRepo.save(skill); 
    }
    
 // Borra Skill por su ID
    public void borrarSkill(long id){
        hardRepo.deleteById(id);
    }
    
}
