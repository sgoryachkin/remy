package org.sg.remy.business.service;

import java.util.List;

import org.sg.remy.business.entity.Category;

public interface CategoryService {
	
	void save(Category category);
	
	Category get(Long id);
	
	List<Category> getAll();

}
