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

	private Collection<Long> groupeIds;
	private Boolean showable;
	private Boolean showableGroup;
	private ProductFilter productFilter;

	public ProductCategoryFilter() {
		super();
	}

	public ProductCategoryFilter(Collection<Long> typeIds,
			Boolean showableType, ProductFilter productFilter) {
		super();
		this.groupeIds = typeIds;
		this.showable = showableType;
		this.productFilter = productFilter;
	}

	public Boolean getShowable() {
		return showable;
	}

	public void setShowable(Boolean showableType) {
		this.showable = showableType;
	}

	public Collection<Long> getGroupIds() {
		return groupeIds;
	}

	public void setGroupeIds(Collection<Long> typeIds) {
		this.groupeIds = typeIds;
	}

	public Boolean getShowableGroup() {
		return showableGroup;
	}

	public void setShowableGroup(Boolean showableGroup) {
		this.showableGroup = showableGroup;
	}

	public ProductFilter getProductFilter() {
		return productFilter;
	}

	public void setProductFilter(ProductFilter productFilter) {
		this.productFilter = productFilter;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(groupeIds).append(this.showable).append(showableGroup)
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
		return new EqualsBuilder().append(this.groupeIds, rhs.groupeIds)
				.append(this.showable, rhs.showable)
				.append(this.showableGroup, rhs.showableGroup)
				.append(this.productFilter, rhs.productFilter).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(this.groupeIds)
				.append(this.showable).append(this.showableGroup).append(productFilter).toString();
	}

}
