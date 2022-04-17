
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.SoftskillModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JLG
 */
@Repository
public interface SoftskillRepository extends CrudRepository<SoftskillModel, Long>{
    
}
