package org.sg.remy.business.model;

import java.util.Collection;

public class RestaurantFilter {
	
	private Collection<Long> categoryIds;

	public Collection<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Collection<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

}
