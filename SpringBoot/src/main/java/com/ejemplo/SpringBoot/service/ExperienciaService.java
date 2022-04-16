
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.ExperienciaModel;
import com.ejemplo.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
}
