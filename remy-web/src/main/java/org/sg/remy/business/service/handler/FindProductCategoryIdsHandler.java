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
import org.sg.remy.business.entity.Product_;
import org.sg.remy.business.model.ProductCategoryFilter;
import org.sg.remy.business.service.action.FindProductCategoryIds;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(FindProductCategoryIds.class)
public class FindProductCategoryIdsHandler implements CommandHandler<FindProductCategoryIds, List<Long>>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Long> execute(FindProductCategoryIds action) {
		return find(action.getProductCategoryFilter());
	}

	private List<Long> find(ProductCategoryFilter categoryFilter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb
				.createQuery(Long.class);
		Root<ProductCategory> root = cq.from(ProductCategory.class);
		
		if (categoryFilter.getShowable() != null) {
			cq.where(cb.equal(root.get(ProductCategory_.showable),
					categoryFilter.getShowable()));
		}
		
		if (categoryFilter.getShowableGroup() != null
				|| (categoryFilter.getGroupIds() != null && !categoryFilter
						.getGroupIds().isEmpty())) {
			
			Join<ProductCategory, ProductCategoryGroup> join = root
					.join(ProductCategory_.productCategoryGroup);
			if (categoryFilter.getShowableGroup() != null) {
				cq.where(cb.equal(join.get(ProductCategoryGroup_.showable),
						categoryFilter.getShowableGroup()));
			}
			if (categoryFilter.getGroupIds() != null
					&& !categoryFilter.getGroupIds().isEmpty()) {
				cq.where(join.get(ProductCategoryGroup_.id).in(
						categoryFilter.getGroupIds()));

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
		cq.select(root.get(ProductCategory_.id));//.distinct(true);

		return em.createQuery(cq).getResultList();
	}




}
