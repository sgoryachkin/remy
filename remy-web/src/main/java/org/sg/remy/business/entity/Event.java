package org.sg.remy.business.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Event extends Listable {
	private static final long serialVersionUID = 5533390808834223992L;

	@ManyToMany(targetEntity = EventCategory.class)
	private List<EventCategory> categories;

	private Date startShowDate;

	private Date startDate;

	private Date endDate;

	public List<EventCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<EventCategory> categories) {
		this.categories = categories;
	}

	public Date getStartShowDate() {
		return startShowDate;
	}

	public void setStartShowDate(Date startShowDate) {
		this.startShowDate = startShowDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
