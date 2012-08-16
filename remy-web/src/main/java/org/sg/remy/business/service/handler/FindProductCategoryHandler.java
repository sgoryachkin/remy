package org.sg.remy.business.service.handler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import org.sg.remy.common.command.api.ActionHandler;

public class FindProductCategoryHandler implements ActionHandler<FindProductCategory, Map<Long, List<ProductCategory>>>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Map<Long, List<ProductCategory>> execute(FindProductCategory command) {
		return findGroupe(command.getProductCategoryFilter());
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

	private Map<Long, List<ProductCategory>> findGroupe(
			ProductCategoryFilter categoryFilter) {
		Map<Long, List<ProductCategory>> result = new LinkedHashMap<Long, List<ProductCategory>>();
		for (ProductCategory category : find(categoryFilter)) {
			Long categpryId = category.getProductCategoryGroup().getId();
			List<ProductCategory> group = result.get(categpryId);
			if (group == null) {
				group = new ArrayList<ProductCategory>();
				result.put(categpryId, group);
			}
			group.add(category);
		}
		return result;
	}

}
