
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.PersonaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaModel, Integer>{

    
    
}
