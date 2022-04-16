
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
@Table(name="hard_skill")
public class HardskillModel implements Serializable{
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhard_skill;
    
    private String nombre_habilidad;
    private Double valor_hab;

    public Long getIdhard_skill() {
        return idhard_skill;
    }

    public void setIdhard_skill(Long idhard_skill) {
        this.idhard_skill = idhard_skill;
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
