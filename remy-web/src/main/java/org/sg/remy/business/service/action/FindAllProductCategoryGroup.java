package org.sg.remy.business.service.action;

import java.util.List;

import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.common.cmd.api.CommandAction;

public class FindAllProductCategoryGroup implements CommandAction<List<ProductCategoryGroup>> {
	private static final long serialVersionUID = 8289171811728368959L;
	
	public FindAllProductCategoryGroup(){
		super();
	}

}
