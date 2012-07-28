package org.sg.remy.business.model;

import java.util.List;

public interface PagingResult<T> {
	
	Long getCount(); 

	Long getPageCount();

	List<T> getResult(); 

}
