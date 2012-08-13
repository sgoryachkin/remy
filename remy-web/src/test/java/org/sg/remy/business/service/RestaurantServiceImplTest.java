package org.sg.remy.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.CategoryType;
import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.model.CategoryFilter;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.RestaurantFilter;
import org.sg.remy.business.service.action.Save;
import org.sg.remy.common.command.api.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class RestaurantServiceImplTest {
	
	@Autowired
	ActionService commandService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	CategoryService referenceService;
	
	@Autowired
	CategoryTypeService categoryTypeService;
	
	
	@Before
	public void init(){
		initCategoryType();
		initCategory();
		initRestaurant();
	}

	
	public void initCategoryType(){
		CategoryType categoryType = new CategoryType();
		categoryType.setName("Тип заведения");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		commandService.doAction(new Save(categoryType));
		
		categoryType = new CategoryType();
		categoryType.setName("Кухня");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		categoryTypeService.save(categoryType);
		
		categoryType = new CategoryType();
		categoryType.setName("Средний чек");
		categoryType.setMultiple(false);
		categoryType.setShowable(true);
		categoryTypeService.save(categoryType);
		
		categoryType = new CategoryType();
		categoryType.setName("Услуги");
		categoryType.setShowable(true);
		categoryType.setMultiple(true);
		categoryTypeService.save(categoryType);
		
	}
	
	public void initCategory(){
		
		List<CategoryType> categoryTypes = categoryTypeService.getAll();
		
		Iterator<CategoryType> cti = categoryTypes.iterator();
		CategoryType categoryType = cti.next();
		
		Category category1 = new Category();
		category1.setName("Бары");
		category1.setCategoryType(categoryType);
		
		Category category2 = new Category();
		category2.setName("Кафе");
		category2.setCategoryType(categoryType);
		
		Category category3 = new Category();
		category3.setName("Доставка");
		category3.setCategoryType(categoryType);
		
		Category category4 = new Category();
		category4.setName("Заведения 18+");
		category4.setCategoryType(categoryType);
		
		Category category5 = new Category();
		category5.setName("Рестораны");
		category5.setCategoryType(categoryType);
		
		Category category6 = new Category();
		category6.setName("Fast Food");
		category6.setCategoryType(categoryType);
		
		Category category7 = new Category();
		category7.setName("Клубы");
		category7.setCategoryType(categoryType);
		
		categoryType = cti.next();
		
		Category category8 = new Category();
		category8.setName("Японская");
		category8.setCategoryType(categoryType);
		
		Category category9 = new Category();
		category9.setName("Корейская");
		category9.setCategoryType(categoryType);
		
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
		
		Category category = new Category();
		category.setName("Дорого");
		category.setCategoryType(categoryType);
		referenceService.save(category);
		
		category = new Category();
		category.setName("Средне");
		category.setCategoryType(categoryType);
		referenceService.save(category);
		
		category = new Category();
		category.setName("Дешево");
		category.setCategoryType(categoryType);
		referenceService.save(category);
		
		categoryType = cti.next();
		
		category = new Category();
		category.setName("Караоке");
		category.setCategoryType(categoryType);
		referenceService.save(category);
		
		category = new Category();
		category.setName("Живая музыка");
		category.setCategoryType(categoryType);
		referenceService.save(category);
		
		category = new Category();
		category.setName("Летняя площадка");
		category.setCategoryType(categoryType);
		referenceService.save(category);
		
		category = new Category();
		category.setName("Детские программы");
		category.setCategoryType(categoryType);
		referenceService.save(category);
		
		category = new Category();
		category.setName("Выездное обслуживание");
		category.setCategoryType(categoryType);
		referenceService.save(category);
				
		
	}
	

	public void initRestaurant(){
		List<Category> categories = referenceService.find(new CategoryFilter());
		
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
		List<Category> categories = referenceService.find(new CategoryFilter());
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
