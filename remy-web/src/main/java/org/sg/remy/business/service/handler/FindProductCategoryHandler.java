package org.sg.remy.business.service.handler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.ProductCategoryFilter;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.business.service.action.FindProductCategory;
import org.sg.remy.business.service.action.FindProductCategoryIds;
import org.sg.remy.business.service.action.FindProductIds;
import org.sg.remy.business.service.action.GetProductCategory;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(FindProductCategory.class)
public class FindProductCategoryHandler implements CommandHandler<FindProductCategory, List<ProductCategory>>{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CommandActionService actionService;

	@Override
	public List<ProductCategory> execute(FindProductCategory command) {
		return find(command.getProductCategoryFilter());
	}

	private List<ProductCategory> find(ProductCategoryFilter categoryFilter) {
		
		List<Long> categoryIds = actionService.doAction(new FindProductCategoryIds(categoryFilter));
		
		if (categoryFilter.getProductFilter()==null){
			categoryFilter.setProductFilter(new ProductFilter());
		}
		
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		
		for (Long categoryId : categoryIds) {

			ProductFilter productFilter = categoryFilter.getProductFilter();
			if (productFilter.getCategoryIds() == null){
				productFilter.setCategoryIds(new ArrayList<Long>());
			} else {
				productFilter.getCategoryIds().clear();
			}
			productFilter.getCategoryIds().add(categoryId);
			
			PagingParam<ProductFilter> pagingParam = new PagingParam<ProductFilter>(1l, 1l, productFilter);
			
			
			ProductCategory productCategory = (ProductCategory) actionService.doAction(new GetProductCategory(categoryId));
			Long productCount = actionService.doAction(new FindProductIds(pagingParam)).getCount();
			productCategory.setProductCount(productCount);
			categories.add(productCategory);
			
		}
		
		return categories;

	}



}
