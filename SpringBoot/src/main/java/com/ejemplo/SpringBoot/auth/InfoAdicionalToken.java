
package com.ejemplo.SpringBoot.auth;

import com.ejemplo.SpringBoot.model.Usuario;
import com.ejemplo.SpringBoot.service.IUsuarioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

/**
 *
 * @author JLG
 */
@Component
public class InfoAdicionalToken implements TokenEnhancer{
    
    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        
        Usuario usuario = usuarioService.findByUsername(authentication.getName());
        Map<String,Object> info = new HashMap<>();
        info.put("info_adicional", "Hola Arg Prog".concat(authentication.getName()));
        
        info.put("nombre", usuario.getNombre());
	info.put("apellido", usuario.getApellido());
	info.put("email", usuario.getEmail());
        
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        
        return accessToken;
    }
    
}
