package org.sg.remy.business.service;

import java.util.List;

import org.sg.remy.business.entity.ProductCategoryGroup;

@Deprecated
public interface CategoryTypeService {
	
	void save(ProductCategoryGroup categoryType);
	
	ProductCategoryGroup get(Long id);
	
	List<ProductCategoryGroup> getAll();
	
	List<ProductCategoryGroup> getAllNoEmpty();

}
