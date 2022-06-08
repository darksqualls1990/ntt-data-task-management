package com.accenture.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto   album compartido  por usuario
 * @author infrahector@hotmail.com
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSharedAlbumDTO implements Serializable {
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID= 1L;
	
	/**
	 * identificador del album
	 */
	private int  idAlbum;
	
	/**
	 * titulo del album
	 */
	private String title;

	/**
	 * permisos del usuario por album
	 */
	private List<UserPermissionDTO> userPermission;
	
	/**
	 * fotos del album
	 */
	private List<PhotoDTO> photos;
	

}
