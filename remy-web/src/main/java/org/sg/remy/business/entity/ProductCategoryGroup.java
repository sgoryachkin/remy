package org.sg.remy.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author sgoryachkin
 * 
 */
@Entity
public class ProductCategoryGroup extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = -4494730681388117292L;

	@NotNull
	@Column(nullable = false)
	private Boolean multiple;
	
	@NotNull
	@Column(nullable = false)
	private Boolean showable;

	public Boolean getShowable() {
		return showable;
	}

	public void setShowable(Boolean showable) {
		this.showable = showable;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

}
