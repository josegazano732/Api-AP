
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.ExperienciaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JLG
 */
@Repository
public interface ExperienciaRepository extends CrudRepository<ExperienciaModel, Long>{

    
    
}
