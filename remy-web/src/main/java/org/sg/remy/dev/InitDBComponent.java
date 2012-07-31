package org.sg.remy.dev;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.CategoryType;
import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.service.CategoryService;
import org.sg.remy.business.service.CategoryTypeService;
import org.sg.remy.business.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDBComponent {
	
	@Autowired
	CategoryTypeService categoryTypeService;
	
	@Autowired
	CategoryService referenceService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@PostConstruct
	public void init(){
		initCategoryType();
		initCategory();
		initRestaurant();
	}
	
	public void initCategoryType(){
		CategoryType categoryType = new CategoryType();
		categoryType.setName("Тип заведения");
		categoryType.setMultiple(true);
		categoryTypeService.save(categoryType);
		
		categoryType = new CategoryType();
		categoryType.setName("Кухня");
		categoryType.setMultiple(true);
		categoryTypeService.save(categoryType);
		
		categoryType = new CategoryType();
		categoryType.setName("Средний чек");
		categoryType.setMultiple(false);
		categoryTypeService.save(categoryType);
		
		categoryType = new CategoryType();
		categoryType.setName("Услуги");
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
		List<Category> categories = referenceService.getAll();
		
		for (int i = 0; i < 251; i++) {
			Restaurant r = new Restaurant();
			r.setCategories(categories);
			r.setName("Заведение " + i);
			r.setDescription("Описание для заведения");
			r.setCategories(categories);
			restaurantService.save(r);
			
		}

	}

}
