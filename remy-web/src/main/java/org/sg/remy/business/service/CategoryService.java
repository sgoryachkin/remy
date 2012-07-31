package org.sg.remy.business.service;

import java.util.List;
import java.util.Map;

import org.sg.remy.business.entity.Category;

public interface CategoryService {
	
	void save(Category category);
	
	Category get(Long id);
	
	List<Category> getByType(Long categoryTypeId);
	
	List<Category> getByTypeNoEmpty(Long categoryTypeId);
	
	List<Category> getAll();
	
	List<Category> getAllNoEmpty(); 
	
	Map<Long, List<Category>> getAllGroup();
	
	Map<Long, List<Category>> getAllGroupNoEmpty(); 

}
