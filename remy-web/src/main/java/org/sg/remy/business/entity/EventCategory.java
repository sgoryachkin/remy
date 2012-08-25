package org.sg.remy.business.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class EventCategory extends AbstractEntity {
	private static final long serialVersionUID = 6138947472671379491L;

	@ManyToMany(targetEntity = Event.class, mappedBy = "categories")
	private List<Event> events;

	@Column(nullable = false)
	private Boolean showable;

	public Boolean getShowable() {
		return showable;
	}

	public void setShowable(Boolean showable) {
		this.showable = showable;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
