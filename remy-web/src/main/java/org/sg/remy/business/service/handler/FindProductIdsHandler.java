package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.sg.remy.business.entity.Product;
import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.entity.Product_;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.PagingResultImpl;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.business.service.action.FindProductIds;
import org.sg.remy.business.util.PagingCriteriaUtils;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.Handler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Handler(action = FindProductIds.class)
public class FindProductIdsHandler implements
		CommandHandler<FindProductIds, PagingResult<Long>> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public PagingResult<Long> execute(FindProductIds command) {
		PagingParam<ProductFilter> param = command.getPagingParam();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);

		Root<Product> fromProduct = cq.from(Product.class);
		Join<Product, ProductCategory> fromProductCategories = fromProduct
				.join(Product_.categories);
		
		// Restrictions
		cq.where(fromProductCategories.get(Product_.id).in(
				param.getFilter().getCategoryIds()));

		PagingResultImpl<Long> pagingResult = new PagingResultImpl<Long>();
		pagingResult.setPage(param.getPage());

		// Set selection for count 
		cq.select(cb.count(fromProduct.get(Product_.id)));
		pagingResult.setCount(em.createQuery(cq).getSingleResult());
		pagingResult.setPageCount(PagingCriteriaUtils.calcPageCount(
				pagingResult.getCount(), param.getPageSize()));

		// Set selection for ids
		cq.select(fromProduct.get(Product_.id));//.distinct(true);
		pagingResult.setResult(em
				.createQuery(cq)
				.setFirstResult(
						PagingCriteriaUtils.calcFirstResult(
								param.getPageSize(), param.getPage())
								.intValue())
				.setMaxResults(((Long) (param.getPageSize())).intValue())
				.getResultList());
		return pagingResult;
	}

}
