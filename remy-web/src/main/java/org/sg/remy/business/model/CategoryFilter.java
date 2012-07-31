package org.sg.remy.business.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author sgoryachkin
 * 
 */
public class CategoryFilter implements Serializable {
	private static final long serialVersionUID = -5188763646803827622L;

	private Collection<Long> typeIds;
	private Boolean showableType;
	private Boolean multipleType;
	private Boolean empty;

	public CategoryFilter() {
		super();
	}

	public CategoryFilter(Collection<Long> typeIds, Boolean showableType,
			Boolean multipleType, Boolean empty) {
		super();
		this.typeIds = typeIds;
		this.showableType = showableType;
		this.multipleType = multipleType;
		this.empty = empty;
	}

	public Boolean getShowableType() {
		return showableType;
	}

	public void setShowableType(Boolean showableType) {
		this.showableType = showableType;
	}

	public Boolean getMultipleType() {
		return multipleType;
	}

	public void setMultipleType(Boolean multipleType) {
		this.multipleType = multipleType;
	}

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}

	public Collection<Long> getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(Collection<Long> typeIds) {
		this.typeIds = typeIds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empty == null) ? 0 : empty.hashCode());
		result = prime * result
				+ ((multipleType == null) ? 0 : multipleType.hashCode());
		result = prime * result
				+ ((showableType == null) ? 0 : showableType.hashCode());
		result = prime * result + ((typeIds == null) ? 0 : typeIds.hashCode());
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
		CategoryFilter other = (CategoryFilter) obj;
		if (empty == null) {
			if (other.empty != null)
				return false;
		} else if (!empty.equals(other.empty))
			return false;
		if (multipleType == null) {
			if (other.multipleType != null)
				return false;
		} else if (!multipleType.equals(other.multipleType))
			return false;
		if (showableType == null) {
			if (other.showableType != null)
				return false;
		} else if (!showableType.equals(other.showableType))
			return false;
		if (typeIds == null) {
			if (other.typeIds != null)
				return false;
		} else if (!typeIds.equals(other.typeIds))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryFilter [typeIds=");
		builder.append(typeIds);
		builder.append(", showableType=");
		builder.append(showableType);
		builder.append(", multipleType=");
		builder.append(multipleType);
		builder.append(", empty=");
		builder.append(empty);
		builder.append("]");
		return builder.toString();
	}

}
