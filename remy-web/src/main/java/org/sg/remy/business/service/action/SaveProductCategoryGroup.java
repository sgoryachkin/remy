package org.sg.remy.business.service.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.common.cmd.api.CommandAction;

public class SaveProductCategoryGroup implements CommandAction<Void>{
	private static final long serialVersionUID = 1781943383915215878L;

	private Collection<ProductCategoryGroup> objects = new ArrayList<ProductCategoryGroup>();

	public SaveProductCategoryGroup() {

	}

	public SaveProductCategoryGroup(Collection<ProductCategoryGroup> objects) {
		super();
		this.objects.addAll(objects);
	}

	public SaveProductCategoryGroup(ProductCategoryGroup object) {
		super();
		this.objects.add(object);
	}

	public Collection<ProductCategoryGroup> getObjects() {
		return objects;
	}

	public void setObjects(Collection<ProductCategoryGroup> objects) {
		this.objects = objects;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(objects).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		SaveProductCategoryGroup rhs = (SaveProductCategoryGroup) obj;
		return new EqualsBuilder().append(objects, rhs.objects).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(objects).toString();
	}

}
