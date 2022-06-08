package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.domain.CommentDTO;
import com.accenture.domain.SharedAlbumDTO;
import com.accenture.domain.UserSharedAlbumDTO;
import com.accenture.exception.ApiException;
import com.accenture.service.ISharedAlbumService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador  que retorna las api del servicio consumidas de jsonplaceholder.typicode.com 
 * 
 * @author infrahector@hotmail.com
 */
@RestController
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
		@ApiResponse(responseCode = "401", description = "No tiene autorización"),
		@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
@Tag(name = "SharedAlbumController", description = "Api's  Para el consumo de los servicios adicionales  ")
@RequestMapping("/shared-album")
public class SharedAlbumController {

	/**
	 *  Servicio que obtiene los metodos para la gestion de los albumnes compartidos
	 */
	@Autowired
	private ISharedAlbumService iSharedAlbumService;
	
	/**
	 * Api  que permite crear asociar un album compartido con sus permisos
	 * 
	 * @param sharedAlbum
	 * @return SharedAlbumDTO
	 * @throws ApiException
	 */
	@Operation(description="Crea los albumnes compartidos a otros usuarios")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@PostMapping()
	public ResponseEntity<SharedAlbumDTO> createShareAlbum(@RequestBody SharedAlbumDTO sharedAlbum) throws ApiException{
		
		SharedAlbumDTO shared=iSharedAlbumService.createShareAlbum(sharedAlbum);
		
		return new ResponseEntity<>(shared,HttpStatus.CREATED);
	}
	
	/**
	 * Api que permite actualizar los permisos de los albumnes compartidos
	 * @param request
	 * @return SharedAlbumDTO
	 * @throws ApiException
	 */
	@Operation(description="Actualiza los permisos de los albumnes compartidos")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@PutMapping()
	public ResponseEntity<SharedAlbumDTO> updateShareAlbum(@RequestBody SharedAlbumDTO request) throws ApiException{
		
		SharedAlbumDTO shared=iSharedAlbumService.updateShareAlbum(request);
		
		return new ResponseEntity<>(shared,HttpStatus.OK);
	}

	/**
	 * Api que permite obtener los usuarios que estan asociados a un album y un permiso 
	 * 
	 * @param idAlbum
	 * @param perRead
	 * @param perWrite
	 * @return UserSharedAlbumDTO
	 * @throws ApiException
	 */
	@Operation(description="Retorna los usuarios que estan asociados a un album y un permiso")
	@GetMapping("/users-shared-folder")
	public @ResponseBody ResponseEntity<UserSharedAlbumDTO> getUsersSharedFolder(@RequestParam  int idAlbum,
			@RequestParam(required=false)  Boolean perRead,
			@RequestParam(required=false)  Boolean perWrite) throws ApiException{
		
		UserSharedAlbumDTO shared=iSharedAlbumService.getUserShareAlbum(idAlbum, perWrite, perRead);
		
		return new ResponseEntity<>(shared,HttpStatus.OK);
	}
	
	/**
	 * Api que permite obtener  los comentarios filtrando por el usuario o  el name del comentario 
	 * 
	 * @param idUser
	 * @param nameComment
	 * @return List<CommentDTO>
	 * @throws ApiException
	 */
	@Operation(description="Retorna los comentarios filtrando por el usuario o  el name del comentario ")
	@GetMapping("/comment")
	public @ResponseBody ResponseEntity<List<CommentDTO>> getUsersSharedFolder(@RequestParam(required=false)  Integer idUser,
			@RequestParam(required=false)  String nameComment) throws ApiException{
		
		List<CommentDTO> shared=iSharedAlbumService.getCommentDTO(idUser, nameComment);
		
		return new ResponseEntity<>(shared,HttpStatus.OK);
	}
}
