/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.ProyectoModel;
import com.ejemplo.SpringBoot.repository.ProyectoRepository;
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
public class ProyectoService {
    
    @Autowired
    ProyectoRepository proyectRepo;
    
    public List<ProyectoModel> verProyecto() {
    return (List<ProyectoModel>) proyectRepo.findAll();
    }
    
    public ResponseEntity<ProyectoModel> proyectoId(Long id) {

        Optional<ProyectoModel> proyecto = proyectRepo.findById(id);

        if (proyecto.isPresent()) {
            return ResponseEntity.ok().body(proyecto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public ProyectoModel guardar(ProyectoModel proyecto) {
        return proyectRepo.save(proyecto); // crea o actualiza
    }
    
    public void borrarProyecto(Long id){
        proyectRepo.deleteById(id);
    }
}
