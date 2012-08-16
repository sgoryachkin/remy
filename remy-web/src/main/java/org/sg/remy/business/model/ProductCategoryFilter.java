package org.sg.remy.business.model;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author sgoryachkin
 * 
 */
public class ProductCategoryFilter implements Serializable {
	private static final long serialVersionUID = -5188763646803827622L;

	private Collection<Long> typeIds;
	private Boolean showableType;
	private ProductFilter productFilter;

	public ProductCategoryFilter() {
		super();
	}

	public ProductCategoryFilter(Collection<Long> typeIds,
			Boolean showableType, ProductFilter productFilter) {
		super();
		this.typeIds = typeIds;
		this.showableType = showableType;
		this.productFilter = productFilter;
	}

	public Boolean getShowableType() {
		return showableType;
	}

	public void setShowableType(Boolean showableType) {
		this.showableType = showableType;
	}

	public Collection<Long> getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(Collection<Long> typeIds) {
		this.typeIds = typeIds;
	}

	public ProductFilter getProductFilter() {
		return productFilter;
	}

	public void setProductFilter(ProductFilter productFilter) {
		this.productFilter = productFilter;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(typeIds).append(this.showableType)
				.append(this.productFilter).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCategoryFilter rhs = (ProductCategoryFilter) obj;
		return new EqualsBuilder().append(this.typeIds, rhs.typeIds)
				.append(this.showableType, rhs.showableType)
				.append(this.productFilter, rhs.productFilter).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(this.typeIds)
				.append(this.showableType).append(productFilter).toString();
	}

}
