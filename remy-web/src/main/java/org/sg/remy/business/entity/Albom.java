package org.sg.remy.business.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Albom implements Serializable {
	private static final long serialVersionUID = 4674953180141177295L;
	
	String albomId;
	String userId;
	
	public String getAlbomId() {
		return albomId;
	}
	public void setAlbomId(String albomId) {
		this.albomId = albomId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
