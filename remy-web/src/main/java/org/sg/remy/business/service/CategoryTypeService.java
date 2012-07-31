package org.sg.remy.business.service;

import java.util.List;

import org.sg.remy.business.entity.CategoryType;

public interface CategoryTypeService {
	
	void save(CategoryType categoryType);
	
	CategoryType get(Long id);
	
	List<CategoryType> getAll();
	
	List<CategoryType> getAllNoEmpty();

}
