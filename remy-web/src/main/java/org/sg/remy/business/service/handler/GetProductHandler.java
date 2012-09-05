package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.entity.Product;
import org.sg.remy.business.service.action.GetProduct;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(GetProduct.class)
public class GetProductHandler implements CommandHandler<GetProduct, Product>{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Product execute(GetProduct command) {
		Product product = em.find(Product.class, command.getId());
		product.getCategories().size();
		return product;
	}

}
