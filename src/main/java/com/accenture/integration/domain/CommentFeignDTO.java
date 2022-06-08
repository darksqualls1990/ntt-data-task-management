package com.accenture.integration.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto del comentario feign
 * 
 * @author infrahector@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentFeignDTO implements Serializable {
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;
	
	/**
	 * Identificador del post
	 */
    public int postId;
    
    /**
     * Identificador del comentario
     */
    public int id;
    
    /**
     * nombre
     */
    public String name;
    
    /**
     * correo electronico
     */
    public String email;
    
    /**
     * Cuerpo
     */
    public String body;

}
