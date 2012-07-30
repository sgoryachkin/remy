package org.sg.remy.business.service;

import java.util.List;

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.CategoryType;

public interface ReferenceService {
	
	void save(Category category);
	
	Category get(Long id);
	
	List<Category> getCategoriesByType(CategoryType categoryType);
	
	List<Category> getCategoriesByTypeNoEmpty(CategoryType categoryType);

}
