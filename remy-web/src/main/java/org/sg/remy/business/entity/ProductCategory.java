package org.sg.remy.business.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ProductCategory extends AbstractEntity {
	private static final long serialVersionUID = -4269680945752767031L;

	@ManyToOne(optional = false)
	private ProductCategoryGroup productCategoryGroup;

	@ManyToMany(targetEntity = Product.class, mappedBy = "categories")
	private List<Product> restaurants;
	
	@Column(nullable = false)
	private Boolean showable;

	public ProductCategoryGroup getProductCategoryGroup() {
		return productCategoryGroup;
	}

	public void setProductCategoryGroup(ProductCategoryGroup productCategoryGroup) {
		this.productCategoryGroup = productCategoryGroup;
	}

	public List<Product> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Product> restaurants) {
		this.restaurants = restaurants;
	}

	public Boolean getShowable() {
		return showable;
	}

	public void setShowable(Boolean showable) {
		this.showable = showable;
	}

}