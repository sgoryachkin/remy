package org.sg.remy.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.sg.remy.business.entity.CategoryType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryTypeServiceImpl implements CategoryTypeService{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(CategoryType categoryType) {
		em.persist(categoryType);
	}

	@Override
	public List<CategoryType> getAll() {
		CriteriaQuery<CategoryType> cq = em.getCriteriaBuilder().createQuery(CategoryType.class);
		cq.from(CategoryType.class);
		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<CategoryType> getAllNoEmpty() {
		// TODO Необходимо реализовать выборку не пустых типов категорий
		return getAll();
	}

	@Override
	public CategoryType get(Long id) {
		return em.find(CategoryType.class, id);
	}

}
