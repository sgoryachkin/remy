package org.sg.remy.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.sg.remy.business.entity.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
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
	public List<Category> getAll() {
		CriteriaQuery<Category> c = em.getCriteriaBuilder().createQuery(Category.class);
		c.from(Category.class);
		return em.createQuery(c).getResultList();
	}

}
