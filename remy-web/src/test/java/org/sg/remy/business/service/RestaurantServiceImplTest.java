package org.sg.remy.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.entity.Product;
import org.sg.remy.business.model.ProductCategoryFilter;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.business.service.action.FindProduct;
import org.sg.remy.business.service.action.Save;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class RestaurantServiceImplTest {
	
	@Autowired
	CommandActionService actionService;
	
	
	//@Before
	public void init(){

	}

		
	@Test
	public void findByCategorySuccess(){
		/*
		Long pageSize = 7l;
		List<ProductCategory> categories = referenceService.find(new ProductCategoryFilter());
		List<Long> categoryIds = new ArrayList<Long>();
		for (ProductCategory category : categories) {
			categoryIds.add(category.getId());
		}
		
		ProductFilter filter = new ProductFilter();
		filter.setCategoryIds(categoryIds);
		
		PagingResult<Product> result = actionService.doAction(new FindProduct(new PagingParam<ProductFilter>(1l, pageSize, filter)));		
		Assert.assertEquals(pageSize, Long.valueOf(result.getResult().size()));
			*/
	}

}
