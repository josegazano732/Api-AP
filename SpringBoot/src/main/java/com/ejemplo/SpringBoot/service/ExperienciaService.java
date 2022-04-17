
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.ExperienciaModel;
import com.ejemplo.SpringBoot.repository.ExperienciaRepository;
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
public class ExperienciaService {
    
    @Autowired
    ExperienciaRepository expeRepo;
    
    public List<ExperienciaModel> verExperiencia() {
        return (List<ExperienciaModel>) expeRepo.findAll();
    }
    
    public ResponseEntity<ExperienciaModel> experienciaId(long id) {

        Optional<ExperienciaModel> experiencia = expeRepo.findById(id);

        if (experiencia.isPresent()) {
            return ResponseEntity.ok().body(experiencia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public ExperienciaModel guardar(ExperienciaModel experiencia) {
        return expeRepo.save(experiencia); // crea o actualiza
    }
    
    public void borrarexperiencia(long id){
        expeRepo.deleteById(id);
    }
}
