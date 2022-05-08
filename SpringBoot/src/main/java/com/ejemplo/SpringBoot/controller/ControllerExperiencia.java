
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.ExperienciaModel;
import com.ejemplo.SpringBoot.service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/experiencia")
public class ControllerExperiencia {
    
    @Autowired
    private ExperienciaService expeServ;
    
    @GetMapping
    public List<ExperienciaModel> verexperiencia() {
        //return ListaExperiencia;
        return expeServ.verExperiencia();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaModel> experienciaId(@PathVariable(value = "id") long id) {
        return expeServ.experienciaId(id);
    }
    
    @PostMapping("/nueva")
    public ExperienciaModel nuevaExperiencia(@RequestBody ExperienciaModel experiencia) {
        return expeServ.guardar(experiencia);
    }
    
    @PutMapping("/actualizar/{id}") //put facil
    public ExperienciaModel actualizarExperiencia(@RequestBody ExperienciaModel experiencia) {
        return expeServ.guardar(experiencia);
    }
    
    @DeleteMapping("borrar/{id}")
    public void borrarExperiencia(@PathVariable long id){
        expeServ.borrarexperiencia(id);
    }
    
    
            
    
}
