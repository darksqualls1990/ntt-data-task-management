package com.accenture.integration.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto post feign
 * 
 * @author infrahector@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFeignDTO  implements Serializable{
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;

	/**
	 * identificador del usuario
	 */
    public int userId;
    
    /**
     * identificador del post
     */
    public int id;
    
    /**
     * titulo
     */
    public String title;
    
    /**
     * cuerpo
     */
    public String body;
}
