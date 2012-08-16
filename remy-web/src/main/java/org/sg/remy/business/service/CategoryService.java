package org.sg.remy.business.service;

import java.util.List;
import java.util.Map;

import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.model.ProductCategoryFilter;

@Deprecated
public interface CategoryService {
	
	@Deprecated
	void save(ProductCategory category);
	
	ProductCategory get(Long id);
	
	List<ProductCategory> find(ProductCategoryFilter categoryFilter);
	
}
