package com.accenture.integration.service;

import java.util.List;

import com.accenture.integration.domain.AlbumFeignDTO;
import com.accenture.integration.domain.CommentFeignDTO;
import com.accenture.integration.domain.PhotoFeignDTO;
import com.accenture.integration.domain.PostFeignDTO;
import com.accenture.integration.domain.UserFeignDTO;

/**
 * Interface json place holder
 * 
 * @author infrahector@hotmail.com
 */
public interface IJsonPlaceHolderService{
	
	
	/**
	 * Servicio que obtiene todos los usuarios
	 * 
	 * @return List<UserFeignDTO> 
	 */
	List<UserFeignDTO> getAllUsers();
	
	/**
	 * Servicio que obtiene los albumnes por usuario
	 * 
	 * @param idUser
	 * @return List<AlbumFeignDTO>
	 */
	List<AlbumFeignDTO> getAlbumsByIdUser(Integer idUser);
	
	/**
	 * Servicio  que obtiene el usuario por id
	 * 
	 * @param idUser
	 * @return UserFeignDTO
	 */
	UserFeignDTO getUserById(int idUser);
	
	/**
	 * Servicio que obtiene  el album por id
	 * 
	 * @param idAlbum
	 * @return AlbumFeignDTO
	 */
	AlbumFeignDTO getAlbumById(int idAlbum);
	
	/**
	 * Servicio que obtiene todas las fotos 
	 * 
	 * @return List<PhotoFeignDTO>
	 */
	List<PhotoFeignDTO> getAllPhoto();
	
	/**
	 * Servicio que obtiene todos las fotos por usuario
	 * 
	 * @param idUser
	 * @return List<PhotoFeignDTO>
	 */
	List<PhotoFeignDTO> getAllPhotoByUser(Integer idUser);
	
	/**
	 * Servicio que obtiene todos los post por usuario
	 * @param idUser
	 * @return List<PostFeignDTO>
	 */
	List<PostFeignDTO> getPostByIdUser(Integer idUser);
	
	/**
	 * Servicio que obtiene todos los comentarios
	 * 
	 * @return List<CommentFeignDTO>
	 */
	List<CommentFeignDTO> getCommentDTO();

}
