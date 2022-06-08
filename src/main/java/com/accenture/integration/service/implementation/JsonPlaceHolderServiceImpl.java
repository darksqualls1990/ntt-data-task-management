package com.accenture.integration.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.accenture.integration.domain.AlbumFeignDTO;
import com.accenture.integration.domain.CommentFeignDTO;
import com.accenture.integration.domain.PhotoFeignDTO;
import com.accenture.integration.domain.PostFeignDTO;
import com.accenture.integration.domain.UserFeignDTO;
import com.accenture.integration.feign.client.IAccentureClient;
import com.accenture.integration.service.IJsonPlaceHolderService;

/**
 * Servicios de json place holder
 * 
 * @author infrahector@hotmail.com
 */
@Service
public class JsonPlaceHolderServiceImpl implements IJsonPlaceHolderService  {
	
	/**
	 * Accenture client
	 */
	@Autowired
	IAccentureClient iAccentureClient;

	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getAllUsers()
	 */
	@Override
	public List<UserFeignDTO> getAllUsers(){
		List<UserFeignDTO>  users= new ArrayList<>();
		users.addAll(iAccentureClient.getAllUsers());
		return users;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getAlbumsByIdUser(java.lang.Integer)
	 */
	@Override
	public List<AlbumFeignDTO> getAlbumsByIdUser(Integer idUser){
		List<AlbumFeignDTO>  albums= new ArrayList<>();
		if(null != idUser) {
			albums.addAll(iAccentureClient.getAlbumsByIdUser(idUser));
		}else {
			albums.addAll(iAccentureClient.getAllAlbums());
		}
		return albums;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getUserById(int)
	 */
	@Override
	public UserFeignDTO getUserById(int idUser){
		UserFeignDTO user=null;
		List<UserFeignDTO> userList=iAccentureClient.getUsersById(idUser);
		if(null != userList && !CollectionUtils.isEmpty(userList)) {
			user=userList.get(0);
		}
		return user;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getAlbumById(int)
	 */
	@Override
	public AlbumFeignDTO getAlbumById(int idAlbum){
		AlbumFeignDTO album=null;
		List<AlbumFeignDTO> albumList=iAccentureClient.getAlbumsById(idAlbum);
		if(null != albumList && !CollectionUtils.isEmpty(albumList)) {
			album=albumList.get(0);
		}
		return album;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getAllPhoto()
	 */
	@Override
	public List<PhotoFeignDTO> getAllPhoto(){
		List<PhotoFeignDTO>  photos= new ArrayList<>();
		photos.addAll(iAccentureClient.getAllPhotos());
		return photos;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getAllPhotoByUser(java.lang.Integer)
	 */
	@Override
	public List<PhotoFeignDTO> getAllPhotoByUser(Integer idUser){
		List<AlbumFeignDTO>  albumsUser=this.getAlbumsByIdUser(idUser);
		List<PhotoFeignDTO>  photos=this.getAllPhoto();
		List<PhotoFeignDTO>  photosUsers=new ArrayList<>();
		for(AlbumFeignDTO album:albumsUser ) {
			List<PhotoFeignDTO> photosUser=photos.stream().filter(p -> p.getAlbumId() > album.getId())
					  .collect(Collectors.toList());
			if(null != photosUser && !CollectionUtils.isEmpty(photosUser) ) {
				photosUsers.addAll(photosUser);
			}
		}
	
		return photosUsers;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getPostByIdUser(java.lang.Integer)
	 */
	@Override
	public List<PostFeignDTO> getPostByIdUser(Integer idUser){
		List<PostFeignDTO>  post= new ArrayList<>();
		post.addAll(iAccentureClient.getPostByIdUser(idUser));
		return post;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accenture.integration.service.IJsonPlaceHolderService#getCommentDTO()
	 */
	@Override
	public List<CommentFeignDTO> getCommentDTO(){
		List<CommentFeignDTO>  comments= new ArrayList<>();
		comments.addAll(iAccentureClient.getAllComment());
		return comments;
	}
	
}
