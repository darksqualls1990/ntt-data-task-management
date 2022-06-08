package com.accenture.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.accenture.database.models.AccSharedAlbumEntity;

/**
 * Interface para las operaciones de la base de datos relacionadas con AccSharedAlbumEntity
 *  
 * @author infrahector@hotmail.com
 */
public interface IAccSharedAlbumRepository extends CrudRepository<AccSharedAlbumEntity, Integer> {

	
	/**
	 * Query que obtiene el album apartir del id del usuario y el id del album
	 * 
	 * @param idUser
	 * @param idAlbum
	 * @return AccSharedAlbumEntity
	 */
	AccSharedAlbumEntity findByIdUserAndIdAlbum(Integer idUser,Integer idAlbum);
	
	/**
	 * Query que obtiene el album apartir del id del album y los permisos
	 * 
	 * @param idAlbum
	 * @param perWrite
	 * @param perRead
	 * @return List<AccSharedAlbumEntity>
	 */
	@Query("SELECT s FROM AccSharedAlbumEntity s "
			+ " WHERE s.idAlbum = :idAlbum "
			+ " AND ( s.perRead = :perRead ) "
			+ " AND ( s.perWrite = :perWrite  ) ")
	List<AccSharedAlbumEntity> findAccSharedAlbumEntityByIdAlmbuAndPermission(@Param("idAlbum") int idAlbum,@Param("perWrite") boolean perWrite,@Param("perRead")  boolean perRead);
		
	/**
	 * Query que obtiene  el album apartir  del id del album y el permiso de escritura
	 * 
	 * @param idAlbum
	 * @param perWrite
	 * @return List<AccSharedAlbumEntity>
	 */
	@Query("SELECT s FROM AccSharedAlbumEntity s "
			+ " WHERE s.idAlbum = :idAlbum "
			+ " AND ( s.perWrite = :perWrite  ) ")
	List<AccSharedAlbumEntity> findByIdAlmbuAndPermissionWrite(@Param("idAlbum") int idAlbum,@Param("perWrite") boolean perWrite);
	
	/**
	 * Query que obtiene  el album apartir  del id del album y el permiso de lectura
	 * 
	 * @param idAlbum
	 * @param perRead
	 * @return List<AccSharedAlbumEntity>
	 */
	@Query("SELECT s FROM AccSharedAlbumEntity s "
			+ " WHERE s.idAlbum = :idAlbum "
			+ " AND ( s.perRead = :perRead ) ")
	List<AccSharedAlbumEntity> findByIdAlmbuAndPermissionRead(@Param("idAlbum") int idAlbum,@Param("perRead")  boolean perRead);
	
}
