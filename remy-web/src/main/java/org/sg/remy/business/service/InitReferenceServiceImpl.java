package org.sg.remy.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.sg.remy.business.entity.Category;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InitReferenceServiceImpl implements InitReferenceService{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Category> updateCategory() {
		Category category1 = new Category();
		category1.setName("Бары");
		
		Category category2 = new Category();
		category2.setName("Кафе");
		
		em.persist(category1);
		em.persist(category2);
		em.flush();
		
		CriteriaQuery<Category> c = em.getCriteriaBuilder().createQuery(Category.class);
		c.from(Category.class);
	
		return em.createQuery(c).getResultList();
	}

}
