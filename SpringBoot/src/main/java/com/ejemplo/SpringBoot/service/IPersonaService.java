
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import java.util.List;


public interface IPersonaService {
    public List<Persona> verPersonas();
    public void agregarPersona(Persona per);
    public void boorrarPersona (Long id);
    public Persona buscarPersona (Long id);
}
