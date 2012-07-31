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

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.CategoryType;
import org.sg.remy.business.entity.CategoryType_;
import org.sg.remy.business.entity.Category_;
import org.sg.remy.business.model.CategoryFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Category category) {
		em.persist(category);
	}

	@Override
	public Category get(Long id) {
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> find(CategoryFilter categoryFilter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		Root<Category> root = cq.from(Category.class);
		if (categoryFilter.getMultipleType() != null
				|| categoryFilter.getShowableType() != null
				|| (categoryFilter.getTypeIds() != null && !categoryFilter
						.getTypeIds().isEmpty())) {
			Join<Category, CategoryType> join = root
					.join(Category_.categoryType);
			if (categoryFilter.getShowableType() != null) {
				cq.where(cb.equal(join.get(CategoryType_.showable),
						categoryFilter.getShowableType()));
			}
			if (categoryFilter.getMultipleType() != null) {
				cq.where(cb.equal(join.get(CategoryType_.multiple),
						categoryFilter.getMultipleType()));
			}
			if (categoryFilter.getTypeIds() != null
					&& !categoryFilter.getTypeIds().isEmpty()) {
				cq.where(join.get(CategoryType_.id).in(
						categoryFilter.getTypeIds()));

			}
			if (categoryFilter.getEmpty() != null) {
				if (categoryFilter.getEmpty()) {
					cq.where(cb.isEmpty(root.get(Category_.restaurants)));
				} else {
					cq.where(cb.isNotEmpty(root.get(Category_.restaurants)));
				}
			}
		}

		return em.createQuery(cq).getResultList();
	}

	@Override
	public Map<Long, List<Category>> findGroupe(CategoryFilter categoryFilter) {
		Map<Long, List<Category>> result = new LinkedHashMap<Long, List<Category>>();
		for (Category category : find(categoryFilter)) {
			Long categpryId = category.getCategoryType().getId();
			List<Category> group = result.get(categpryId);
			if (group == null) {
				group = new ArrayList<Category>();
				result.put(categpryId, group);
			}
			group.add(category);
		}
		return result;
	}

}
