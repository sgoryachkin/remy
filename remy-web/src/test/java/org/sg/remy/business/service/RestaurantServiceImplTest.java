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
import org.sg.remy.common.command.api.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class RestaurantServiceImplTest {
	
	@Autowired
	ActionService actionService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	CategoryService referenceService;
	
	@Autowired
	CategoryTypeService categoryTypeService;
	
	
	//@Before
	public void init(){
		initCategoryType();
		initCategory();
		initRestaurant();
	}

	
	public void initCategoryType(){
		ProductCategoryGroup categoryType = new ProductCategoryGroup();
		categoryType.setName("Тип заведения");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		actionService.doAction(new Save(categoryType));
		
		categoryType = new ProductCategoryGroup();
		categoryType.setName("Кухня");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		categoryTypeService.save(categoryType);
		
		categoryType = new ProductCategoryGroup();
		categoryType.setName("Средний чек");
		categoryType.setMultiple(false);
		categoryType.setShowable(true);
		categoryTypeService.save(categoryType);
		
		categoryType = new ProductCategoryGroup();
		categoryType.setName("Услуги");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		categoryTypeService.save(categoryType);
		
	}
	
	public void initCategory(){
		
		List<ProductCategoryGroup> categoryTypes = categoryTypeService.getAll();
		
		Iterator<ProductCategoryGroup> cti = categoryTypes.iterator();
		ProductCategoryGroup categoryType = cti.next();
		
		ProductCategory category1 = new ProductCategory();
		category1.setName("Бары");
		category1.setProductCategoryGroup(categoryType);
		
		ProductCategory category2 = new ProductCategory();
		category2.setName("Кафе");
		category2.setProductCategoryGroup(categoryType);
		
		ProductCategory category3 = new ProductCategory();
		category3.setName("Доставка");
		category3.setProductCategoryGroup(categoryType);
		
		ProductCategory category4 = new ProductCategory();
		category4.setName("Заведения 18+");
		category4.setProductCategoryGroup(categoryType);
		
		ProductCategory category5 = new ProductCategory();
		category5.setName("Рестораны");
		category5.setProductCategoryGroup(categoryType);
		
		ProductCategory category6 = new ProductCategory();
		category6.setName("Fast Food");
		category6.setProductCategoryGroup(categoryType);
		
		ProductCategory category7 = new ProductCategory();
		category7.setName("Клубы");
		category7.setProductCategoryGroup(categoryType);
		
		categoryType = cti.next();
		
		ProductCategory category8 = new ProductCategory();
		category8.setName("Японская");
		category8.setProductCategoryGroup(categoryType);
		
		ProductCategory category9 = new ProductCategory();
		category9.setName("Корейская");
		category9.setProductCategoryGroup(categoryType);
		
		referenceService.save(category1);
		referenceService.save(category2);
		referenceService.save(category3);
		referenceService.save(category4);
		referenceService.save(category5);
		referenceService.save(category6);
		referenceService.save(category7);
		referenceService.save(category8);
		referenceService.save(category9);
		
		categoryType = cti.next();
		
		ProductCategory category = new ProductCategory();
		category.setName("Дорого");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
		
		category = new ProductCategory();
		category.setName("Средне");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
		
		category = new ProductCategory();
		category.setName("Дешево");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
		
		categoryType = cti.next();
		
		category = new ProductCategory();
		category.setName("Караоке");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
		
		category = new ProductCategory();
		category.setName("Живая музыка");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
		
		category = new ProductCategory();
		category.setName("Летняя площадка");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
		
		category = new ProductCategory();
		category.setName("Детские программы");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
		
		category = new ProductCategory();
		category.setName("Выездное обслуживание");
		category.setProductCategoryGroup(categoryType);
		referenceService.save(category);
				
		
	}
	

	public void initRestaurant(){
		List<ProductCategory> categories = referenceService.find(new ProductCategoryFilter());
		
		for (int i = 0; i < 251; i++) {
			Product r = new Product();
			r.setCategories(categories);
			r.setName("Заведение " + i);
			r.setDescription("Описание для заведения");
			r.setCategories(categories);
			restaurantService.save(r);
			
		}

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
