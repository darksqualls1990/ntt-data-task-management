package com.accenture.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto album compartido
 * 
 * @author infrahector@hotmail.com
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SharedAlbumDTO implements Serializable {
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;
	
	/**
	 * identificador del archivo compartido
	 */
	private int idSharedFolder;
	
	/**
	 * identificador del album
	 */
	private  int idAlbum;
	
	/**
	 * identificador del usuario
	 */
	private int idUser;
	
	/**
	 * permiso de lectura
	 */
	private boolean perRead;
	
	/**
	 * permiso de escritura
	 */
	private boolean perWrite; 

}
