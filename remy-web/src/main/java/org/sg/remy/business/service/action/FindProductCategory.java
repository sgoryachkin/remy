package org.sg.remy.business.service.action;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.business.model.ProductCategoryFilter;

public class FindProductCategory {
	
	private ProductCategoryFilter productCategoryFilter;
	
	public FindProductCategory(){
		super();
	}
	
	public FindProductCategory(ProductCategoryFilter productCategoryFilter){
		this.productCategoryFilter = productCategoryFilter;
	}

	public ProductCategoryFilter getProductCategoryFilter() {
		return productCategoryFilter;
	}

	public void setProductCategoryFilter(ProductCategoryFilter productCategoryFilter) {
		this.productCategoryFilter = productCategoryFilter;
	}
	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.productCategoryFilter).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;
	    FindProductCategory rhs = (FindProductCategory) obj;
        return new EqualsBuilder().append(this.productCategoryFilter, rhs.productCategoryFilter).isEquals();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this.productCategoryFilter).toString();
	}
	

}
