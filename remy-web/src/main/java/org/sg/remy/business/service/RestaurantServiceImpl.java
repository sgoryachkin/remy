package org.sg.remy.business.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.Category_;
import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.entity.Restaurant_;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.PagingResultImpl;
import org.sg.remy.business.model.RestaurantFilter;
import org.sg.remy.business.util.PagingCriteriaUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@PersistenceContext
	EntityManager em;

	@Override
	public Restaurant get(Long id) {
		Restaurant restaurant = em.find(Restaurant.class, id);
		restaurant.getCategories().size();
		return restaurant;
	}

	@Override
	public void save(Restaurant restaurant) {
		em.persist(restaurant);
	}

	@Override
	public PagingResult<Restaurant> find(PagingParam<RestaurantFilter> param) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Restaurant> cqlist = em.getCriteriaBuilder().createQuery(
				Restaurant.class);
		CriteriaQuery<Long> cqcount = em.getCriteriaBuilder().createQuery(
				Long.class);

		Root<Restaurant> rlist = cqlist.from(Restaurant.class);
		Root<Restaurant> rcount = cqcount.from(Restaurant.class);

		Join<Restaurant, Category> listJoinToCategory = rlist
				.join(Restaurant_.categories);
		cqlist.where(listJoinToCategory.get(Category_.id).in(
				param.getFilter().getCategoryIds()));

		Join<Restaurant, Category> countJoinToCategory = rcount
				.join(Restaurant_.categories);
		cqcount.where(countJoinToCategory.get(Category_.id).in(
				param.getFilter().getCategoryIds()));
		cqcount.select(cb.count(rcount));

		PagingResultImpl<Restaurant> pagingResult = new PagingResultImpl<Restaurant>();

		pagingResult.setPage(param.getPage());
		pagingResult.setCount(em.createQuery(cqcount).getSingleResult());
		pagingResult.setPageCount(PagingCriteriaUtils.calcPageCount(
				pagingResult.getCount(), param.getPageSize()));

		pagingResult.setResult(em
				.createQuery(cqlist)
				.setFirstResult(
						PagingCriteriaUtils.calcFirstResult(
								param.getPageSize(), param.getPage())
								.intValue())
				.setMaxResults(((Long) (param.getPageSize())).intValue())
				.getResultList());

		return pagingResult;

	}

}
