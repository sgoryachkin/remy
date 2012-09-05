package org.sg.remy.business.service.action;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.common.cmd.api.CommandAction;

public class FindProductIds implements CommandAction<PagingResult<Long>>{
	private static final long serialVersionUID = -1949958005718397244L;
	
	private PagingParam<ProductFilter> pagingParam;
	
	public FindProductIds(){}
	
	public FindProductIds(PagingParam<ProductFilter> pagingParam){
		this.pagingParam = pagingParam;
	}
	
	public PagingParam<ProductFilter> getPagingParam() {
		return pagingParam;
	}

	public void setPagingParam(PagingParam<ProductFilter> pagingParam) {
		this.pagingParam = pagingParam;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(pagingParam).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;
		FindProductIds rhs = (FindProductIds) obj;
        return new EqualsBuilder().append(this.pagingParam, rhs.pagingParam).isEquals();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this.pagingParam).toString();
	}
	
	
}
