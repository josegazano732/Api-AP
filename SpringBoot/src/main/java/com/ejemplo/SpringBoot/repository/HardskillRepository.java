
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.HardskillModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JLG
 */
@Repository
public interface HardskillRepository extends CrudRepository<HardskillModel, Long>{
    
}
