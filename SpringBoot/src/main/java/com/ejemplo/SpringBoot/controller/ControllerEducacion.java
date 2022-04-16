
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.EducacionModel;
import com.ejemplo.SpringBoot.service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @GetMapping("/{id}")
    public ResponseEntity<EducacionModel> EducacionId(@PathVariable(value = "id") Long id) {
        return educServ.educacionId(id);
    }
    
    @PostMapping("/nueva")
    public EducacionModel nuevaInstitucion(@Validated @RequestBody EducacionModel educacion) {
        return educServ.guardar(educacion);
    }
    
}
