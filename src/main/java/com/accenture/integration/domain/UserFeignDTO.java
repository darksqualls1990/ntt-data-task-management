package com.accenture.integration.domain;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto usuario feign
 * 
 * @author infrahector@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFeignDTO implements Serializable {
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;

	/**
	 * identificador del usuario
	 */
    public int id;
    
    /**
     * nombre
     */
    public String name;
    
    /**
     * usuario 
     */
    public String username;
    
    /**
     * correo electronico
     */
    public String email;
    
    /**
     * telefono
     */
    public String phone;
    
    /**
     * sitio web
     */
    public String website;
}
