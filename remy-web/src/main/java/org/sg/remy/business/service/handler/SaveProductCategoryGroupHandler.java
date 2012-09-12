package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.service.action.SaveProductCategoryGroup;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(SaveProductCategoryGroup.class)
public class SaveProductCategoryGroupHandler implements CommandHandler<SaveProductCategoryGroup, Void> {

	@PersistenceContext
	EntityManager em;

	@Override
	public Void execute(SaveProductCategoryGroup command) {
		for (ProductCategoryGroup object : command.getObjects()) {
			em.persist(object);
		}
		return null;
	}

}
