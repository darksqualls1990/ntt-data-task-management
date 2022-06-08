package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.integration.domain.AlbumFeignDTO;
import com.accenture.integration.domain.PhotoFeignDTO;
import com.accenture.integration.domain.UserFeignDTO;
import com.accenture.integration.service.IJsonPlaceHolderService;

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
@Tag(name = "ServiceController", description = "Api's  Para el consumo de servicios jsonplaceholder.typicode.com ")
@RequestMapping("/service")
public class AccentureController {


	/**
	 * Servicio que obtiene los metodos para json place holder
	 */
	@Autowired
	private IJsonPlaceHolderService iJsonPlaceHolderService;
	
	/**
	 * Api que retorna todos los usuarios de  JsonPlaceHolder 
	 * 
	 * @return List<UserFeignDTO>
	 */
	@Operation(description="Retorna todos los usuarios de  JsonPlaceHolder")
	@GetMapping("/users")
	public ResponseEntity<List<UserFeignDTO>>  getUsers(){
		
		return ResponseEntity.ok(iJsonPlaceHolderService.getAllUsers());
	}	
	
	/**
	 * Api que retorna todas las fotos de  JsonPlaceHolder 
	 *  
	 * @return List<PhotoFeignDTO>
	 */
	@Operation(description="Retorna todas las fotos de  JsonPlaceHolder")
	@GetMapping("/photos")
	public ResponseEntity<List<PhotoFeignDTO>>  getAllPhotos(){
		
		return ResponseEntity.ok(iJsonPlaceHolderService.getAllPhoto());
	}
	
	/**
	 * Api que retorna todos los albumnes o el de algun usuario  de  JsonPlaceHolder 
	 * 
	 * @param idUser
	 * @return List<AlbumFeignDTO>
	 */
	@Operation(description="Retorna todos los albumnes o albumnes especificos de un usuario")
	@GetMapping("/albums/{idUser}")
	public ResponseEntity<List<AlbumFeignDTO>>  getAlbums(@PathVariable(required=false)   Integer idUser){
		
		return ResponseEntity.ok(iJsonPlaceHolderService.getAlbumsByIdUser(idUser));
	}
	
	/**
	 * Api que retorna todas las fotos de un usuario  de  JsonPlaceHolder 
	 * 
	 * @param idUser
	 * @return List<PhotoFeignDTO>
	 */
	@GetMapping("/photos/{idUser}")
	public ResponseEntity<List<PhotoFeignDTO>>  getAllPhotosByIdUser(@PathVariable(required=false)   Integer idUser){
		
		return ResponseEntity.ok(iJsonPlaceHolderService.getAllPhotoByUser(idUser));
	}
}
