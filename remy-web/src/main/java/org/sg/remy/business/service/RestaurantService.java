package org.sg.remy.business.service;

import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.service.model.PagingParam;
import org.sg.remy.business.service.model.PagingResult;
import org.sg.remy.business.service.model.RestaurantFilter;

public interface RestaurantService {
	
	Restaurant get(Long id);
	void save(Restaurant restaurant);
	PagingResult<Restaurant> findByCategory(PagingParam<Long> param);
	PagingResult<Restaurant> findByFilter(PagingParam<RestaurantFilter> param);
	
}
