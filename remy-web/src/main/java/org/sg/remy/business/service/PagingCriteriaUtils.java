package org.sg.remy.business.service;

public class PagingCriteriaUtils {
	
	private PagingCriteriaUtils(){}
	
	public static Long calcPageCount(Long total, Long pageSize){
		return total / pageSize;
	}
	
	public static Long calcFirstRow(Long pageSize, Long page){
		return pageSize * (page - 1);
	}

}
