package org.sg.remy.business.service.action;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.business.entity.Listable;
import org.sg.remy.business.entity.Product;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.common.command.api.Action;

public class FindProduct implements Serializable, Action<PagingResult<Listable>>{
	private static final long serialVersionUID = -1949958005718397244L;
	
	private PagingParam<ProductFilter> pagingParam;
	
	public FindProduct(){}
	
	public FindProduct(PagingParam<ProductFilter> pagingParam){
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
		FindProduct rhs = (FindProduct) obj;
        return new EqualsBuilder().append(this.pagingParam, rhs.pagingParam).isEquals();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this.pagingParam).toString();
	}
	
	
}
