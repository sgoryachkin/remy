package org.sg.remy.business.model;

import java.io.Serializable;
import java.util.Collection;

public class ProductFilter implements Serializable{
	private static final long serialVersionUID = -1296668376596428590L;
	
	private Collection<Long> categoryIds;

	public Collection<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Collection<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryIds == null) ? 0 : categoryIds.hashCode());
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
		ProductFilter other = (ProductFilter) obj;
		if (categoryIds == null) {
			if (other.categoryIds != null)
				return false;
		} else if (!categoryIds.equals(other.categoryIds))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantFilter [categoryIds=");
		builder.append(categoryIds);
		builder.append("]");
		return builder.toString();
	}

}
