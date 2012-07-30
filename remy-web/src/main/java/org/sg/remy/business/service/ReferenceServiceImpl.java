package org.sg.remy.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.CategoryType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReferenceServiceImpl implements ReferenceService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Category category) {
		em.persist(category);
	}

	@Override
	public Category get(Long id) {
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> getCategoriesByType(CategoryType categoryType) {
		CriteriaQuery<Category> cq = em.getCriteriaBuilder().createQuery(
				Category.class);		// TODO Auto-generated method stub
		Root<Category> root = cq.from(Category.class);
		// cq.where(root.get(Category_.))

		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<Category> getCategoriesByTypeNoEmpty(CategoryType categoryType) {
		// TODO Auto-generated method stub
		return null;
	}

}
