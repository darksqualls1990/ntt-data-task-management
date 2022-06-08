package com.accenture.integration.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto foto feign
 * 
 * @author infrahector@hotmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoFeignDTO implements Serializable{
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;
	
	/**
	 * album id
	 */
    public int albumId;
    
    /**
     * identificador de la foto
     */
    public int id;
    
    /**
     * titulo
     */
    public String title;
    
    /**
     * url
     */
    public String url;
    
    /**
     * url
     */
    public String thumbnailUrl;

}
