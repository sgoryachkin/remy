package org.sg.remy.business.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;


@Embeddable
public class Albom {
	
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
