/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.ProyectoModel;
import com.ejemplo.SpringBoot.service.ProyectoService;
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
@RequestMapping("api/proyecto")
public class ControllerProyecto {
    
    @Autowired
    private ProyectoService proyecServ;
    
    @GetMapping
    public List<ProyectoModel> verProyecto() {
        //return ListaPersonas;
        return proyecServ.verProyecto();
    }
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/{id}")
    public ResponseEntity<ProyectoModel> ProyectoId(@PathVariable(value = "id") Long id) {
        return proyecServ.proyectoId(id);
    }
    
    @Secured("ROLE_ADMIN")
    @PostMapping("/nueva")
    public ProyectoModel nuevaProyecto(@RequestBody ProyectoModel proyecto) {
        return proyecServ.guardar(proyecto);
    }
    
    @Secured("ROLE_ADMIN")
    @PutMapping("/actualizar/{id}") //put facil
    public ProyectoModel actualizarProyecto(@RequestBody ProyectoModel proyecto) {
        return proyecServ.guardar(proyecto);
    }
    
    @Secured("ROLE_ADMIN")
    @PutMapping("/modificar/{id}") //put dificil
    public ResponseEntity<ProyectoModel> actualizarProyectoDos(@PathVariable(value = "id") long id, @Validated @RequestBody ProyectoModel proyecto) {
        if (id == proyecto.getId()) {
            ProyectoModel proyectoNueva = proyecServ.guardar(proyecto);
            return ResponseEntity.ok().body(proyectoNueva);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Secured("ROLE_ADMIN")
    @DeleteMapping("borrar/{id}")
    public void borrarProyecto(@PathVariable long id){
        proyecServ.borrarProyecto(id);
    }
    
}
