package org.sg.remy.business.service;

import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.RestaurantFilter;

public interface RestaurantService {
	
	Restaurant get(Long id);
	void save(Restaurant restaurant);
	PagingResult<Restaurant> find(PagingParam<RestaurantFilter> param);
	
}
