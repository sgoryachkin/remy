package org.sg.remy.business.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.CategoryType;
import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.RestaurantFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class RestaurantServiceImplTest {
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	ReferenceService referenceService;
	
	
	@Before
	public void init(){
		System.out.println("init");
		initCategory();
		initRestaurant();
	}

	public void initCategory(){
		
		
		Category category1 = new Category();
		category1.setName("Бары");
		category1.setCategoryType(CategoryType.CATEGORY);
		
		Category category2 = new Category();
		category2.setName("Кафе");
		category2.setCategoryType(CategoryType.CATEGORY);
		
		Category category3 = new Category();
		category3.setName("Доставка");
		category3.setCategoryType(CategoryType.CATEGORY);
		
		Category category4 = new Category();
		category4.setName("Заведения 18+");
		category4.setCategoryType(CategoryType.CATEGORY);
		
		Category category5 = new Category();
		category5.setName("Рестораны");
		category5.setCategoryType(CategoryType.CATEGORY);
		
		Category category6 = new Category();
		category6.setName("Fast Food");
		category6.setCategoryType(CategoryType.CATEGORY);
		
		Category category7 = new Category();
		category7.setName("Клубы");
		category7.setCategoryType(CategoryType.CATEGORY);
		
		Category category8 = new Category();
		category8.setName("Японская");
		category8.setCategoryType(CategoryType.KITCHEN);
		
		Category category9 = new Category();
		category9.setName("Корейская");
		category9.setCategoryType(CategoryType.KITCHEN);
		
		referenceService.save(category1);
		referenceService.save(category2);
		referenceService.save(category3);
		referenceService.save(category4);
		referenceService.save(category5);
		referenceService.save(category6);
		referenceService.save(category7);
		referenceService.save(category8);
		referenceService.save(category9);
		
		
			
	}
	

	public void initRestaurant(){
		List<Category> categories = referenceService.getCategoriesByType(CategoryType.CATEGORY);
		
		for (int i = 0; i < 251; i++) {
			Restaurant r = new Restaurant();
			r.setCategories(categories);
			r.setName("Заведение " + i);
			r.setDescription("Описание для заведения");
			r.setCategories(categories);
			restaurantService.save(r);
			
		}

	}
	
	
	@Test
	public void findByCategorySuccess(){
		
		Long pageSize = 7l;
		List<Category> categories = referenceService.getCategoriesByType(CategoryType.CATEGORY);
		List<Long> categoryIds = new ArrayList<Long>();
		for (Category category : categories) {
			categoryIds.add(category.getId());
		}
		
		RestaurantFilter filter = new RestaurantFilter();
		filter.setCategoryIds(categoryIds);
		
		PagingResult<Restaurant> result = restaurantService.find(new PagingParam<RestaurantFilter>(1l, pageSize, filter));		
		Assert.assertEquals(pageSize, Long.valueOf(result.getResult().size()));
			
	}

}
