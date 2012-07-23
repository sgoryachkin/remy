package org.sg.remy.business.service;

import java.util.List;

import org.sg.remy.business.entity.Restaurant;

public interface RestaurantService {
	
	Restaurant get(Long id);
	void save(Restaurant restaurant);
	List<Restaurant> find(RestaurantFindParam param);

}
