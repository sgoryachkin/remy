package org.sg.remy.business.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Product extends Listable implements Serializable{
	private static final long serialVersionUID = 8126340023455157654L;

	@ManyToMany(targetEntity=ProductCategory.class)
	private List<ProductCategory> categories;

	
	public List<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}

}
