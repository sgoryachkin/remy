package org.sg.remy.business.util;

public class PagingCriteriaUtils {
	
	private PagingCriteriaUtils(){}
	
	public static Long calcPageCount(Long total, Long pageSize){
		return total % pageSize > 0 ? total / pageSize + 1: total / pageSize; 
	}
	
	public static Long calcFirstResult(Long pageSize, Long page){
		return pageSize * (page - 1);
	}

}
