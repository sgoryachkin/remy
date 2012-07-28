package org.sg.remy.business.model;

import java.io.Serializable;

public class PagingParam<T> implements Serializable{
	private static final long serialVersionUID = -4885029395197339313L;
	
	private Long page;
	private Long pageSize;
	private T filter;
	
	public PagingParam(){}
	
	public PagingParam(Long page, Long pageSize, T filter) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.filter = filter;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public T getFilter() {
		return filter;
	}

	public void setFilter(T filter) {
		this.filter = filter;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filter == null) ? 0 : filter.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result
				+ ((pageSize == null) ? 0 : pageSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		PagingParam<T> other = (PagingParam<T>) obj;
		if (filter == null) {
			if (other.filter != null)
				return false;
		} else if (!filter.equals(other.filter))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PagingParam [page=");
		builder.append(page);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", filter=");
		builder.append(filter);
		builder.append("]");
		return builder.toString();
	}

}
