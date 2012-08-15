package org.sg.remy.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.sg.remy.business.entity.ProductCategoryGroup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryTypeServiceImpl implements CategoryTypeService{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(ProductCategoryGroup categoryType) {
		em.persist(categoryType);
	}

	@Override
	public List<ProductCategoryGroup> getAll() {
		CriteriaQuery<ProductCategoryGroup> cq = em.getCriteriaBuilder().createQuery(ProductCategoryGroup.class);
		cq.from(ProductCategoryGroup.class);
		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<ProductCategoryGroup> getAllNoEmpty() {
		// TODO Необходимо реализовать выборку не пустых типов категорий
		return getAll();
	}

	@Override
	public ProductCategoryGroup get(Long id) {
		return em.find(ProductCategoryGroup.class, id);
	}

}
