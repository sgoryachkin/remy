package org.sg.remy.business.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.entity.ProductCategory_;
import org.sg.remy.business.entity.Product;
import org.sg.remy.business.entity.Product_;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.PagingResultImpl;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.business.util.PagingCriteriaUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@PersistenceContext
	EntityManager em;

	@Override
	public Product get(Long id) {
		Product restaurant = em.find(Product.class, id);
		restaurant.getCategories().size();
		return restaurant;
	}

	@Override
	public void save(Product restaurant) {
		em.persist(restaurant);
	}


}
