package org.sg.remy.portal.service;

import java.util.List;

import org.sg.remy.portal.entity.Restaurant;

public interface RestaurantService {
	
	Restaurant get(Long id);
	void save(Restaurant restaurant);
	List<Restaurant> find(RestaurantFindParam param);

}
