package org.sg.remy.business.service.model;

import java.io.Serializable;
import java.util.List;

public class PagingResultImpl<T> implements PagingResult<T>, Serializable {
	private static final long serialVersionUID = -866798316202950642L;

	private Long count;
	private Long pageCount;
	private List<T> result;

	public PagingResultImpl() {
	}

	public PagingResultImpl(Long count, List<T> result) {
		super();
		this.count = count;
		this.result = result;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}


}
