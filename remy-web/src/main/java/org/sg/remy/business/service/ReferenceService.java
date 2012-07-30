package org.sg.remy.business.service;

import java.util.List;

import org.sg.remy.business.entity.Reference;

public interface ReferenceService {
	
	void save(Reference category);
	
	<T extends Reference> T get(Class<T> clazz, Long id);
	
	<T extends Reference> List<T> getAll(Class<T> clazz);
	
	<T extends Reference> List<T> getAllNoEmpty(Class<T> clazz);

}
