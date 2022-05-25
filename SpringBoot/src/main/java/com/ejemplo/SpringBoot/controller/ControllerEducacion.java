
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.EducacionModel;
import com.ejemplo.SpringBoot.service.EducacionService;
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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/educacion")
public class ControllerEducacion {
    
    @Autowired
    private EducacionService educServ;
    
    @GetMapping
    public List<EducacionModel> verInstitucion() {
        //return ListaPersonas;
        return educServ.verInstitucion();
    }
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/{id}")
    public ResponseEntity<EducacionModel> EducacionId(@PathVariable(value = "id") Long id) {
        return educServ.educacionId(id);
    }
    
    @Secured("ROLE_ADMIN")
    @PostMapping("/nueva")
    public EducacionModel nuevaInstitucion(@RequestBody EducacionModel educacion) {
        return educServ.guardar(educacion);
    }
     
    @Secured("ROLE_ADMIN")
    @PutMapping("/actualizar/{id}") //put facil
    public EducacionModel actualizarEducacion(@RequestBody EducacionModel educacion) {
        return educServ.guardar(educacion);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/modificar/{id}") //put dificil
    public ResponseEntity<EducacionModel> actualizarEducacionDos(@PathVariable(value = "id") long id, @Validated @RequestBody EducacionModel educacion) {
        if (id == educacion.getId()) {
            EducacionModel educacionNueva = educServ.guardar(educacion);
            return ResponseEntity.ok().body(educacionNueva);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Secured("ROLE_ADMIN")
    @DeleteMapping("borrar/{id}")
    public void borrarInstitucion(@PathVariable long id){
        educServ.borrarInstitucion(id);
    }
    
}
