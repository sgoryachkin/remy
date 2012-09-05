package org.sg.remy.business.service.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.sg.remy.common.command.api.CommandAction;

public class Save implements CommandAction<Void>{
	private static final long serialVersionUID = 1781943383915235878L;

	private Collection<Object> objects = new ArrayList<Object>();

	public Save() {

	}

	public Save(Collection<Object> objects) {
		super();
		this.objects.addAll(objects);
	}

	public Save(Object object) {
		super();
		this.objects.add(object);
	}

	public Collection<Object> getObjects() {
		return objects;
	}

	public void setObjects(Collection<Object> objects) {
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

		Save rhs = (Save) obj;
		return new EqualsBuilder().append(objects, rhs.objects).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(objects).toString();
	}

}
