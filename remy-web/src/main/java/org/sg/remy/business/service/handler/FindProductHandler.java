package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.sg.remy.business.entity.Product;
import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.entity.ProductCategory_;
import org.sg.remy.business.entity.Product_;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.PagingResultImpl;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.business.service.action.FindProduct;
import org.sg.remy.business.util.PagingCriteriaUtils;
import org.sg.remy.common.command.api.ActionHandler;
import org.sg.remy.common.command.api.Handler;

@Handler(action = FindProduct.class)
public class FindProductHandler implements ActionHandler<FindProduct, PagingResult<Product>>{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public PagingResult<Product> execute(FindProduct command) {
		PagingParam<ProductFilter> param = command.getPagingParam();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Product> cqlist = em.getCriteriaBuilder().createQuery(
				Product.class);
		CriteriaQuery<Long> cqcount = em.getCriteriaBuilder().createQuery(
				Long.class);

		Root<Product> rlist = cqlist.from(Product.class);
		Root<Product> rcount = cqcount.from(Product.class);

		Join<Product, ProductCategory> listJoinToCategory = rlist
				.join(Product_.categories);
		cqlist.where(listJoinToCategory.get(Product_.id).in(
				param.getFilter().getCategoryIds()));

		Join<Product, ProductCategory> countJoinToCategory = rcount
				.join(Product_.categories);
		cqcount.where(countJoinToCategory.get(ProductCategory_.id).in(
				param.getFilter().getCategoryIds()));
		cqcount.select(cb.count(rcount));

		PagingResultImpl<Product> pagingResult = new PagingResultImpl<Product>();

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
