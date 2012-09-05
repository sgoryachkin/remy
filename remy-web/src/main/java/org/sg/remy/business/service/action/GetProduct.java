package org.sg.remy.business.service.action;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.business.entity.Product;
import org.sg.remy.common.command.api.CommandAction;

public class GetProduct implements Serializable, CommandAction<Product>{
	private static final long serialVersionUID = 7688473178937520203L;
	
	private Long id;
	
	public GetProduct(){}
	
	public GetProduct(Long id){
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;
		GetProduct rhs = (GetProduct) obj;
        return new EqualsBuilder().append(this.id, rhs.id).isEquals();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this.id).toString();
	}

}
