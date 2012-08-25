package org.sg.remy.business.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

@Entity
public class Listable extends AbstractEntity implements Serializable{
	private static final long serialVersionUID = -7163590531646409878L;

	@Lob
	@Basic(fetch=FetchType.EAGER)
	private String description;
	
	@Embedded
	private Albom gallery;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Albom getGallery() {
		return gallery;
	}

	public void setGallery(Albom gallery) {
		this.gallery = gallery;
	}

}
