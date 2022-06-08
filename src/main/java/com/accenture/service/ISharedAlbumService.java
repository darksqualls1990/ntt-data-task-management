package com.accenture.service;

import java.util.List;

import com.accenture.domain.CommentDTO;
import com.accenture.domain.SharedAlbumDTO;
import com.accenture.domain.UserSharedAlbumDTO;
import com.accenture.exception.ApiException;

/**
 * Interface de los albumes compartidos
 * 
 * @author infrahector@hotmail.com
 *
 */
public interface ISharedAlbumService {
	
	/**
	 * Servicio que permite compartir los albumnes  y permisos
	 * 
	 * @param album
	 * @return SharedAlbumDTO
	 * @throws ApiException
	 */
	SharedAlbumDTO createShareAlbum(SharedAlbumDTO album) throws ApiException;
	
	/**
	 * Servicio que actualiza los permisos de los albumnes compartidos
	 * 
	 * @param sharedAlbum
	 * @return SharedAlbumDTO
	 * @throws ApiException
	 */
	SharedAlbumDTO updateShareAlbum(SharedAlbumDTO sharedAlbum) throws ApiException;
	
	/**
	 * Servicio  que obtiene los usuarios  asociados a un album y cierto permiso
	 * 
	 * @param idAlbum
	 * @param perWrite
	 * @param perRead
	 * @return UserSharedAlbumDTO
	 * @throws ApiException
	 */
	UserSharedAlbumDTO getUserShareAlbum(int idAlbum,Boolean perWrite, Boolean perRead) throws ApiException;
	
	/**
	 * Servicio que obtiene los comentarios filtrados por id de user o name del comentario
	 * 
	 * @param idUser
	 * @param nameComment
	 * @return List<CommentDTO>
	 * @throws ApiException
	 */
	List<CommentDTO> getCommentDTO(Integer idUser, String nameComment) throws ApiException;

}
