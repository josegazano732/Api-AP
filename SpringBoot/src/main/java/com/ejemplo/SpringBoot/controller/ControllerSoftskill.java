
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.SoftskillModel;
import com.ejemplo.SpringBoot.service.SoftskillService;
import java.util.List;
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

/**
 *
 * @author JLG
 */
@RestController
@RequestMapping("api/softskill")
public class ControllerSoftskill {
    
    @Autowired
    private SoftskillService softServ;
    
    @GetMapping //Mapea todo los Skill.
    public List<SoftskillModel> verSkill() {
        //return ListaPersonas;
        return softServ.verSkill();
    }
    
    
    @GetMapping("/{id}") // Mapea skill por su ID.
    public ResponseEntity<SoftskillModel> PersonasId(@PathVariable(value = "id") long id) {
        return softServ.skillId(id);
    }
    
    
     @PostMapping("/nueva")//Crea un Skill nuevo.
    public SoftskillModel nuevaSkill(@Validated @RequestBody SoftskillModel skill) {
        return softServ.guardar(skill);
    }
    
    
    @PutMapping("/actualizar/{id}") //put facil //Actualiza Skill por su ID.
    public SoftskillModel actualizarSkill(@Validated @RequestBody SoftskillModel skill) {
        return softServ.guardar(skill);
    }
    
    
    @DeleteMapping("borrar/{id}")//Borra Skill por su ID
    public void borrarSkill(@PathVariable long id){
        softServ.borrarSkill(id);
    }

}
