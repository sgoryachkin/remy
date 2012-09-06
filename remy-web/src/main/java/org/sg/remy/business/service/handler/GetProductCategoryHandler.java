package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.service.action.GetProductCategory;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(GetProductCategory.class)
public class GetProductCategoryHandler implements CommandHandler<GetProductCategory, ProductCategory>{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public ProductCategory execute(GetProductCategory command) {
		ProductCategory productCategory = em.find(ProductCategory.class, command.getId());
		return productCategory;
	}

}
