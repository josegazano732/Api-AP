
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Usuario;

/**
 *
 * @author JLG
 */
public interface IUsuarioService {
    public Usuario findByUsername(String username);
    
}
