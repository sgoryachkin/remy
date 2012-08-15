package org.sg.remy.business.service;

import org.sg.remy.business.entity.Product;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.ProductFilter;

@Deprecated
public interface RestaurantService {
	
	Product get(Long id);
	@Deprecated
	void save(Product restaurant);
	
}
