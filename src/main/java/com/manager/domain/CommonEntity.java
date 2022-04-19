package com.manager.domain;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author subhrajit
 *
 */
@MappedSuperclass // A mapped superclass dont have table defination
public class CommonEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreationTimestamp
	@Column(name="created_dt",updatable=false, nullable=false)
	private Timestamp createdDt;
	
	@UpdateTimestamp
	@Column(name="updated_dt", nullable=false)
	private Timestamp updatedDt;


	public Timestamp getCreatedDt() {
		return createdDt;
	}


	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}


	public Timestamp getUpdatedDt() {
		return updatedDt;
	}


	public void setUpdatedDt(Timestamp updatedDt) {
		this.updatedDt = updatedDt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDt == null) ? 0 : createdDt.hashCode());
		result = prime * result + ((updatedDt == null) ? 0 : updatedDt.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommonEntity other = (CommonEntity) obj;
		if (createdDt == null) {
			if (other.createdDt != null)
				return false;
		} else if (!createdDt.equals(other.createdDt))
			return false;
		if (updatedDt == null) {
			if (other.updatedDt != null)
				return false;
		} else if (!updatedDt.equals(other.updatedDt))
			return false;
		return true;
	}

	
	
}
