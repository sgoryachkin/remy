package org.sg.remy.business.service.action;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.business.model.ProductCategoryFilter;
import org.sg.remy.common.cmd.api.CommandAction;

public class FindProductCategoryIds implements CommandAction<List<Long>> {
	private static final long serialVersionUID = 8289171811728368959L;
	
	private ProductCategoryFilter productCategoryFilter;
	
	public FindProductCategoryIds(){
		super();
	}
	
	public FindProductCategoryIds(ProductCategoryFilter productCategoryFilter){
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
	    FindProductCategoryIds rhs = (FindProductCategoryIds) obj;
        return new EqualsBuilder().append(this.productCategoryFilter, rhs.productCategoryFilter).isEquals();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this.productCategoryFilter).toString();
	}
	

}
