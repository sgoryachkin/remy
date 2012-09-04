package org.sg.remy.business.service.action;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.business.entity.Listable;
import org.sg.remy.common.command.api.Action;

public class GetListable implements Serializable, Action<Listable>{
	private static final long serialVersionUID = -9064270900820473599L;
	
	private Long id;
	
	public GetListable(){}
	
	public GetListable(Long id){
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
		GetListable rhs = (GetListable) obj;
        return new EqualsBuilder().append(this.id, rhs.id).isEquals();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this.id).toString();
	}

}
