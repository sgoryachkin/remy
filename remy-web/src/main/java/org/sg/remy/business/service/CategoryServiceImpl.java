package org.sg.remy.business.service;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(ProductCategory category) {
		em.persist(category);
	}

	@Override
	public ProductCategory get(Long id) {
		return em.find(ProductCategory.class, id);
	}

	@Override
	public List<ProductCategory> find(ProductCategoryFilter categoryFilter) {
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
