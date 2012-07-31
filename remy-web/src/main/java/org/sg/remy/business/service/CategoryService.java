package org.sg.remy.business.service;

import java.util.List;
import java.util.Map;

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.model.CategoryFilter;

public interface CategoryService {
	
	void save(Category category);
	
	Category get(Long id);
	
	List<Category> find(CategoryFilter categoryFilter);
	
	Map<Long, List<Category>> findGroupe(CategoryFilter categoryFilter);
	
}
