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
	public List<Category> getByType(Long categoryTypeId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		Root<Category> root = cq.from(Category.class);
		Join<Category, CategoryType> join = root.join(Category_.categoryType);
		cq.where(cb.equal(join.get(CategoryType_.id), categoryTypeId));

		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<Category> getByTypeNoEmpty(Long categoryTypeId) {
		return getByType(categoryTypeId);
	}

	@Override
	public List<Category> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		cq.from(Category.class);
		return em.createQuery(cq).getResultList();
	}

	@Override
	public Map<Long, List<Category>> getAllGroup() {
		return groupByCategoryType(getAll());
	}

	@Override
	public Map<Long, List<Category>> getAllGroupNoEmpty() {
		return groupByCategoryType(getAllNoEmpty());
	}

	@Override
	public List<Category> getAllNoEmpty() {
		// TODO Нужно реализовать
		return getAll();
	}

	private Map<Long, List<Category>> groupByCategoryType(
			List<Category> categories) {
		Map<Long, List<Category>> result = new LinkedHashMap<Long, List<Category>>();
		for (Category category : categories) {
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
