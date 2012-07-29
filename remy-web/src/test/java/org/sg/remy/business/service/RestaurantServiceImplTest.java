package org.sg.remy.business.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sg.remy.business.entity.Category;
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
	CategoryService categoryService;
	
	
	@Before
	public void init(){
		System.out.println("init");
		initCategory();
		initRestaurant();
	}

	public void initCategory(){
		
		Category category1 = new Category();
		category1.setName("Бары");
		
		Category category2 = new Category();
		category2.setName("Кафе");
		
		Category category3 = new Category();
		category2.setName("Доставка");
		
		Category category4 = new Category();
		category2.setName("Заведения 18+");
		
		Category category5 = new Category();
		category2.setName("Рестораны");
		
		Category category6 = new Category();
		category2.setName("Fast Food");
		
		Category category7 = new Category();
		category2.setName("Клубы");
		
		categoryService.save(category1);
		categoryService.save(category2);
		categoryService.save(category3);
		categoryService.save(category4);
		categoryService.save(category5);
		categoryService.save(category6);
		categoryService.save(category7);
			
	}
	

	public void initRestaurant(){
		List<Category> categories = categoryService.getAll();
		
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
		List<Category> categories = categoryService.getAll();
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
