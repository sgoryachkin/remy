package org.sg.remy.business.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author sgoryachkin
 *
 */
@Entity
public class Category {

	@Id
	public Long id;
	public String name;
	public String desc;

}
