package com.accenture.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.database.models.AccSharedAlbumEntity;
import com.accenture.database.repositories.IAccSharedAlbumRepository;
import com.accenture.domain.CommentDTO;
import com.accenture.domain.SharedAlbumDTO;
import com.accenture.domain.UserPermissionDTO;
import com.accenture.domain.UserSharedAlbumDTO;
import com.accenture.exception.ApiException;
import com.accenture.exception.ApiValidationException;
import com.accenture.integration.domain.AlbumFeignDTO;
import com.accenture.integration.domain.CommentFeignDTO;
import com.accenture.integration.domain.PostFeignDTO;
import com.accenture.integration.domain.UserFeignDTO;
import com.accenture.integration.service.IJsonPlaceHolderService;
import com.accenture.service.ISharedAlbumService;
import com.accenture.util.enums.ErrorEnum;
import com.accenture.util.log.LogUtil;
import com.accenture.util.mapper.GeneralMapper;
import com.accenture.util.message.MessageCommon;

/**
 * Servicios de los albumnes compartidos
 * 
 * @author infrahector@hotmail.com
 */
@Service
public class SharedAlbumServiceImpl implements ISharedAlbumService {
	
	private static final String LABEL_SHARE_ALBUM="sharedAlbumDTO";

	/**
	 * Servicios de json place holder
	 */
	@Autowired
	private IJsonPlaceHolderService iJsonPlaceHolderService;

	/**
	 * Repositorios de los albumnes compartidos
	 */
	@Autowired
	private IAccSharedAlbumRepository iAccSharedAlbumRepository;

	/**
	 * general mapper
	 */
	@Autowired
	private GeneralMapper generalMapper;

	/*
	 * (non-Javadoc)
	 * @see com.accenture.service.ISharedAlbumService#createShareAlbum(com.accenture.domain.SharedAlbumDTO)
	 */
	@Override
	public SharedAlbumDTO createShareAlbum(SharedAlbumDTO sharedAlbum) throws ApiException {
		LogUtil.info(getClass(), String.format(MessageCommon.LOG_INFO_OPERATION_INIT, "createShareAlbum", LABEL_SHARE_ALBUM));
		List<AlbumFeignDTO> albums = iJsonPlaceHolderService.getAlbumsByIdUser(sharedAlbum.getIdUser());

		AlbumFeignDTO resulAlbumOwn = albums.stream().filter(a -> a.getId() == sharedAlbum.getIdAlbum()).findFirst()
				.orElse(null);

		if (null != resulAlbumOwn) {
			throw new ApiValidationException("Album Propio");
		}

		UserFeignDTO userExist = iJsonPlaceHolderService.getUserById(sharedAlbum.getIdUser());

		if (null == userExist) {
			throw new ApiValidationException("No existe el usuario");
		}

		AccSharedAlbumEntity existSharedAlbum = iAccSharedAlbumRepository
				.findByIdUserAndIdAlbum(sharedAlbum.getIdUser(), sharedAlbum.getIdAlbum());

		if (null != existSharedAlbum) {
			throw new ApiValidationException("Ya existe el album compartido a este usuario");
		}

		AccSharedAlbumEntity sharedAlbumNew = generalMapper.mapConverter(sharedAlbum, AccSharedAlbumEntity.class);
		sharedAlbumNew = iAccSharedAlbumRepository.save(sharedAlbumNew);
		LogUtil.info(getClass(), String.format(MessageCommon.LOG_INFO_OPERATION_FINISH, "createShareAlbum", LABEL_SHARE_ALBUM));
		return generalMapper.mapConverter(sharedAlbumNew, SharedAlbumDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * @see com.accenture.service.ISharedAlbumService#updateShareAlbum(com.accenture.domain.SharedAlbumDTO)
	 */
	@Override
	public SharedAlbumDTO updateShareAlbum(SharedAlbumDTO sharedAlbum) throws ApiException {

		Optional<AccSharedAlbumEntity> accSharedAlbum = iAccSharedAlbumRepository
				.findById(sharedAlbum.getIdSharedFolder());

		if (!accSharedAlbum.isPresent()) {
			throw new ApiException(ErrorEnum.MSJ_NOT_DATA);
		}

		AccSharedAlbumEntity sharedAlbumUpdate = accSharedAlbum.get();
		sharedAlbumUpdate.setPerRead(sharedAlbum.isPerRead());
		sharedAlbumUpdate.setPerWrite(sharedAlbum.isPerWrite());

		sharedAlbumUpdate = iAccSharedAlbumRepository.save(sharedAlbumUpdate);

		return generalMapper.mapConverter(sharedAlbumUpdate, SharedAlbumDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * @see com.accenture.service.ISharedAlbumService#getUserShareAlbum(int, java.lang.Boolean, java.lang.Boolean)
	 */
	@Override
	public UserSharedAlbumDTO getUserShareAlbum(int idAlbum, Boolean perWrite, Boolean perRead) throws ApiException {

		UserSharedAlbumDTO userSharedAlbumDTO = new UserSharedAlbumDTO();
		userSharedAlbumDTO.setPhotos(new ArrayList<>());

		List<AccSharedAlbumEntity> sharedAlbums = null;
		if (null == perWrite && null == perRead) {
			throw new ApiException(ErrorEnum.MSJ_NOT_DATA);
		}

		if (null != perWrite && null != perRead) {
			sharedAlbums = iAccSharedAlbumRepository.findAccSharedAlbumEntityByIdAlmbuAndPermission(idAlbum, perWrite,
					perRead);
		} else if (null != perWrite) {
			sharedAlbums = iAccSharedAlbumRepository.findByIdAlmbuAndPermissionWrite(idAlbum, perWrite);
		} else {
			sharedAlbums = iAccSharedAlbumRepository.findByIdAlmbuAndPermissionRead(idAlbum, perRead);
		}

		if (sharedAlbums != null) {
			AlbumFeignDTO albumDTO = iJsonPlaceHolderService.getAlbumById(idAlbum);

			userSharedAlbumDTO.setTitle(albumDTO.getTitle());
			userSharedAlbumDTO.setIdAlbum(albumDTO.getId());
			userSharedAlbumDTO.setUserPermission(new ArrayList<>());

			sharedAlbums.stream().forEach((s) -> {
				UserPermissionDTO userPermissionDTO = new UserPermissionDTO();
				userPermissionDTO.setIdSharedFolder(s.getIdSharedFolder());
				userPermissionDTO.setIdUser(s.getIdUser());
				userPermissionDTO.setPerRead(s.isPerRead());
				userPermissionDTO.setPerWrite(s.isPerWrite());
				UserFeignDTO userFeign = this.iJsonPlaceHolderService.getUserById(s.getIdUser());
				userPermissionDTO.setName(userFeign.getName());
				userSharedAlbumDTO.getUserPermission().add(userPermissionDTO);

			});
		}
		return userSharedAlbumDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see com.accenture.service.ISharedAlbumService#getCommentDTO(java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<CommentDTO> getCommentDTO(Integer idUser, String nameComment) throws ApiException {

		List<Integer> listIdsPost = new ArrayList<>();
		List<CommentDTO> listComment = new ArrayList<>();
		List<Predicate<CommentFeignDTO>> allPredicates = new ArrayList<Predicate<CommentFeignDTO>>();
		

		if (idUser == null && StringUtils.isBlank(nameComment)) {
			throw new ApiException(ErrorEnum.MSJ_NOT_DATA);
		}

		if(StringUtils.isNoneBlank(nameComment)) {
			allPredicates.add(c ->  StringUtils.upperCase(c.getName()).contains(StringUtils.upperCase(nameComment)));  
		}
		
		if (null != idUser) {
			List<PostFeignDTO> listPost = this.iJsonPlaceHolderService.getPostByIdUser(idUser);

			listIdsPost.addAll(listPost.stream().map(PostFeignDTO::getId).collect(Collectors.toList()));
			allPredicates.add(c -> listIdsPost.contains(c.getPostId()));
		}
	
		List<CommentFeignDTO> listCommentFeign= iJsonPlaceHolderService.getCommentDTO();
		
		
		listCommentFeign=	listCommentFeign.stream()
	              .filter(allPredicates.stream().reduce(x->true, Predicate::and))
				  .collect(Collectors.toList());
		
		listComment= generalMapper.mapIterableConverter(listCommentFeign, CommentDTO.class);

		return listComment;
	}

}
