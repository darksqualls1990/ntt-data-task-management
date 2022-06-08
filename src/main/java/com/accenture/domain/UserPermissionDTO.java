package com.accenture.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto usuario  permisos 
 * 
 * @author infrahector@hotmail.com
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPermissionDTO implements Serializable {
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;
	
	/**
	 * identificador del usuario
	 */
	private  int idUser;
	
	/**
	 * nombre del usuario
	 */
	private  String name;
	
	/**
	 * permiso de lectura
	 */
	private boolean perRead;
	
	/**
	 * permiso de escritura
	 */
	private boolean perWrite;
	
	/**
	 * identificador del album compartido
	 */
	private int idSharedFolder;
	
}
