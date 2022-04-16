
package com.ejemplo.SpringBoot.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JLG
 */
@Entity
@Table(name="loguin")
public class LoguinModel implements Serializable{

    @Id
    private Long idloguin;

    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;

    public Long getIdloguin() {
        return idloguin;
    }

    public void setIdloguin(Long idloguin) {
        this.idloguin = idloguin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
    
}
