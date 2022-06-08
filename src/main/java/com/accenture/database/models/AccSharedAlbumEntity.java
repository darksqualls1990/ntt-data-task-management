package com.accenture.database.models;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

/**
 * Clase de persistencia para el  acc_shared_folder tabla de base de datos
 * 
 * @author infrahector@hotmail.com
 */
@Data
@Entity
@Table(name="acc_shared_folder")
public class AccSharedAlbumEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="ACCENTURE_SHARED_FOLDER_ID_GENERATOR", initialValue = 1, allocationSize = 1, sequenceName = "sec_accenture_shared_folder")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCENTURE_SHARED_FOLDER_ID_GENERATOR")
	@Column(name = "id_shared_folder_",unique = true,nullable = false)
	private Integer idSharedFolder;
	
	@Column(name = "id_album")
	private Integer idAlbum;
	
	@Column(name = "id_usser")
	private Integer idUser;
	
	@Column(name = "per_read")
	@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean perRead;
	
	@Column(name = "per_write")
	@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean perWrite;

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccSharedAlbumEntity other = (AccSharedAlbumEntity) obj;
		if (idSharedFolder == null) {
			if (other.idSharedFolder != null)
				return false;
		} else if (!idSharedFolder.equals(other.idSharedFolder))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSharedFolder == null) ? 0 : idSharedFolder.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccentureSharedAlbumEntity [idSharedFolder=" + idSharedFolder + "]";
	}
	
	
	
}
