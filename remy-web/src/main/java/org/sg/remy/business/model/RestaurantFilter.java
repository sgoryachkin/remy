package org.sg.remy.business.model;

import java.util.Collection;

public class RestaurantFilter {
	
	private Collection<Long> categoryIds;
	private Collection<Long> kitchenIds;

	public Collection<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Collection<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public Collection<Long> getKitchenIds() {
		return kitchenIds;
	}

	public void setKitchenIds(Collection<Long> kitchenIds) {
		this.kitchenIds = kitchenIds;
	}

}
