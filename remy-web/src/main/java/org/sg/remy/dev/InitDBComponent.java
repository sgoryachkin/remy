package org.sg.remy.dev;

import java.util.List;

import javax.annotation.PostConstruct;

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.service.CategoryService;
import org.sg.remy.business.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDBComponent {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@PostConstruct
	public void init(){
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

}
