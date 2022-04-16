
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.EducacionModel;
import com.ejemplo.SpringBoot.repository.EducacionRepository;
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
public class EducacionService {
    
    @Autowired
    EducacionRepository educRepo;
    
    public List<EducacionModel> verInstitucion() {
    return (List<EducacionModel>) educRepo.findAll();
    }
    
    public ResponseEntity<EducacionModel> educacionId(Long id) {

        Optional<EducacionModel> educacion = educRepo.findById(id);

        if (educacion.isPresent()) {
            return ResponseEntity.ok().body(educacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public EducacionModel guardar(EducacionModel educacion) {
        return educRepo.save(educacion); // crea o actualiza
    }
    
    public void borrarInstitucion(Long id){
        educRepo.deleteById(id);
    }
    
}
