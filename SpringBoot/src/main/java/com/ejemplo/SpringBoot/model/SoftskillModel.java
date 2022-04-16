
package com.ejemplo.SpringBoot.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JLG
 */
@Entity
@Table(name="soft_skill")
public class SoftskillModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsoft_skill;
    
    private String nombre_habilidad;
    private Double valor_hab;

    public Long getIdsoft_skill() {
        return idsoft_skill;
    }

    public void setIdsoft_skill(Long idsoft_skill) {
        this.idsoft_skill = idsoft_skill;
    }

    public String getNombre_habilidad() {
        return nombre_habilidad;
    }

    public void setNombre_habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }

    public Double getValor_hab() {
        return valor_hab;
    }

    public void setValor_hab(Double valor_hab) {
        this.valor_hab = valor_hab;
    }

   
    
    
}
