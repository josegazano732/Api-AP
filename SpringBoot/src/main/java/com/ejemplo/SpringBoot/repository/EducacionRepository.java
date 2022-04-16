

package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.EducacionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JLG
 */
@Repository
public interface EducacionRepository extends CrudRepository<EducacionModel, Long>{
    
}
