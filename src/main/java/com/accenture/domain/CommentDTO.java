package com.accenture.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto comentario
 * 
 * @author infrahector@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;
	
	/**
	 * identificador post
	 */
    public int postId;
    
    /**
     * identificador del comentario
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
     * cuerpo
     */
    public String body;

}
