
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.HardskillModel;
import com.ejemplo.SpringBoot.service.HardskillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/hardskill")
public class ControllerHardskill {
    
    @Autowired
    private HardskillService hardServ;
    
    @GetMapping //Mapea todo los Skill.
    public List<HardskillModel> verSkill() {
        //return ListaPersonas;
        return hardServ.verSkill();
    }
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/{id}") // Mapea skill por su ID.
    public ResponseEntity<HardskillModel> skillId(@PathVariable(value = "id") long id) {
        return hardServ.skillId(id);
    }
    
    @Secured("ROLE_ADMIN")
    @PostMapping("/nueva")//Crea un Skill nuevo.
    public HardskillModel nuevaSkill(@RequestBody HardskillModel skill) {
        return hardServ.guardar(skill);
    }
    
    @Secured("ROLE_ADMIN")
    @PutMapping("/actualizar/{id}") //put facil //Actualiza Skill por su ID.
    public HardskillModel actualizarSkill(@RequestBody HardskillModel skill) {
        return hardServ.guardar(skill);
    }
    
    @Secured("ROLE_ADMIN")
    @DeleteMapping("borrar/{id}")//Borra Skill por su ID
    public void borrarSkill(@PathVariable long id){
        hardServ.borrarSkill(id);
    }
    
}
