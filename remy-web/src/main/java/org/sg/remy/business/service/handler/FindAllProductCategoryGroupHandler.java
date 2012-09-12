package org.sg.remy.business.service.handler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.service.action.FindAllProductCategoryGroup;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(FindAllProductCategoryGroup.class)
public class FindAllProductCategoryGroupHandler implements CommandHandler<FindAllProductCategoryGroup, List<ProductCategoryGroup>>{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CommandActionService actionService;

	@Override
	public List<ProductCategoryGroup> execute(FindAllProductCategoryGroup command) {
		CriteriaQuery<ProductCategoryGroup> cq = em.getCriteriaBuilder().createQuery(ProductCategoryGroup.class);
		cq.from(ProductCategoryGroup.class);
		return em.createQuery(cq).getResultList();
	}

}
