package org.sg.remy.business.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ProductCategory extends AbstractEntity {
	private static final long serialVersionUID = -4269680945752767031L;

	@ManyToOne(optional = false)
	private ProductCategoryGroup productCategoryGroup;

	@ManyToMany(targetEntity = Product.class, mappedBy = "categories")
	private List<Product> products;
	
	@Column(nullable = false)
	private Boolean showable;
	
	@Transient
	private Long productCount;

	public ProductCategoryGroup getProductCategoryGroup() {
		return productCategoryGroup;
	}

	public void setProductCategoryGroup(ProductCategoryGroup productCategoryGroup) {
		this.productCategoryGroup = productCategoryGroup;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Boolean getShowable() {
		return showable;
	}

	public void setShowable(Boolean showable) {
		this.showable = showable;
	}

	public Long getProductCount() {
		return productCount;
	}

	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}

}
