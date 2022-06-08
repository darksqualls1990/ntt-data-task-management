package com.accenture.integration.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.accenture.integration.domain.AlbumFeignDTO;
import com.accenture.integration.domain.CommentFeignDTO;
import com.accenture.integration.domain.PhotoFeignDTO;
import com.accenture.integration.domain.PostFeignDTO;
import com.accenture.integration.domain.UserFeignDTO;

/**
 * Interface que comunica con json place holder
 * 
 * @author infrahector@hotmail.com
 */
@FeignClient(value = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface IAccentureClient {

	/**
	 * Metodo que  obtiene todos los usuarios
	 * 
	 * @return List<UserFeignDTO>
	 */
	@GetMapping(value = "/users", name="users")
	List<UserFeignDTO> getAllUsers();
	
	/**
	 * Metodo que obtiene todas las fotos 
	 * 
	 * @return List<PhotoFeignDTO>
	 */
	@GetMapping(value = "/photos", name="photos")
	List<PhotoFeignDTO> getAllPhotos();
	
	/**
	 * Metodo que obtiene todos los albumnes 
	 * 
	 * @return List<AlbumFeignDTO>
	 */
	@GetMapping(value = "/albums", name="albums")
	List<AlbumFeignDTO> getAllAlbums();
	
	/**
	 * Metodo que obtiene el usuario por id del usuario
	 * 
	 * @param id
	 * @return List<UserFeignDTO>
	 */
	@GetMapping(value = "/users?id={idUser}", name="userById")
	List<UserFeignDTO> getUsersById(@PathVariable("idUser") int id);
	
	/**
	 * Metodo que obtiene los albumnes por usuario
	 * @param idUser
	 * @return List<AlbumFeignDTO>
	 */
	@GetMapping(value = "/users/{idUser}/albums", name="albumByUser")
	List<AlbumFeignDTO> getAlbumsByIdUser(@PathVariable("idUser") int idUser);
	
	/**
	 * Metodo que retorna el album por id
	 * 
	 * @param idAlbum
	 * @return List<AlbumFeignDTO>
	 */
	@GetMapping(value = "/albums?id={idAlbum}", name="albumById")
	List<AlbumFeignDTO> getAlbumsById(@PathVariable("idAlbum") int idAlbum);
	
	/**
	 * Metodo que obtiene los post por el id de usuario
	 * 
	 * @param idUser
	 * @return List<PostFeignDTO>
	 */
	@GetMapping(value = "/users/{idUser}/posts", name="postByIdUser")
	List<PostFeignDTO> getPostByIdUser(@PathVariable("idUser") Integer idUser);
	
	
	/**
	 * Metodo que obtiene  todo los comment 
	 * 
	 * @return List<CommentFeignDTO>
	 */
	@GetMapping(value = "/comments", name="comment")
	List<CommentFeignDTO> getAllComment();
}
