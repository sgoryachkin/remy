package org.sg.remy.business.service.handler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.entity.ProductCategoryGroup_;
import org.sg.remy.business.entity.ProductCategory_;
import org.sg.remy.business.model.ProductCategoryFilter;
import org.sg.remy.business.service.action.FindProductCategory;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(FindProductCategory.class)
public class FindProductCategoryHandler implements CommandHandler<FindProductCategory, List<ProductCategory>>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ProductCategory> execute(FindProductCategory command) {
		return find(command.getProductCategoryFilter());
	}

	private List<ProductCategory> find(ProductCategoryFilter categoryFilter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductCategory> cq = cb
				.createQuery(ProductCategory.class);
		Root<ProductCategory> root = cq.from(ProductCategory.class);
		if (categoryFilter.getShowableType() != null
				|| (categoryFilter.getTypeIds() != null && !categoryFilter
						.getTypeIds().isEmpty())) {
			Join<ProductCategory, ProductCategoryGroup> join = root
					.join(ProductCategory_.productCategoryGroup);
			if (categoryFilter.getShowableType() != null) {
				cq.where(cb.equal(join.get(ProductCategoryGroup_.showable),
						categoryFilter.getShowableType()));
			}
			if (categoryFilter.getTypeIds() != null
					&& !categoryFilter.getTypeIds().isEmpty()) {
				cq.where(join.get(ProductCategoryGroup_.id).in(
						categoryFilter.getTypeIds()));

			}
			/*
			if (categoryFilter.getEmpty() != null) {
				if (categoryFilter.getEmpty()) {
					cq.where(cb.isEmpty(root.get(ProductCategory_.restaurants)));
				} else {
					cq.where(cb.isNotEmpty(root
							.get(ProductCategory_.restaurants)));
				}
			}
			*/
		}

		return em.createQuery(cq).getResultList();
	}



}
