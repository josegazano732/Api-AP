/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter  //Son las dos anotation que nos permiten agregar todos los getter y setter.
@Entity 
public class Persona implements Serializable {  
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    
    public Persona () {
        
    }
    
    public Persona (Long id,String nombre,String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
