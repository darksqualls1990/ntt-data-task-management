package com.accenture.integration.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO album feign
 * 
 * @author infrahector@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumFeignDTO implements Serializable {
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;
	
	/**
	 *  Identificador del usuario
	 */
	public int userId;
	
	/**
	 * identificador del album
	 */
    public int id;
    
    /**
     * Titulo del album
     */
    public String title;

}
