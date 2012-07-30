package org.sg.remy.dev;

import java.util.List;

import javax.annotation.PostConstruct;

import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.Kitchen;
import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.service.ReferenceService;
import org.sg.remy.business.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDBComponent {
	
	@Autowired
	ReferenceService referenceService;
	
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
		category3.setName("Доставка");
		
		Category category4 = new Category();
		category4.setName("Заведения 18+");
		
		Category category5 = new Category();
		category5.setName("Рестораны");
		
		Category category6 = new Category();
		category6.setName("Fast Food");
		
		Category category7 = new Category();
		category7.setName("Клубы");
		
		referenceService.save(category1);
		referenceService.save(category2);
		referenceService.save(category3);
		referenceService.save(category4);
		referenceService.save(category5);
		referenceService.save(category6);
		referenceService.save(category7);
		
		Kitchen kitchen1 = new Kitchen();
		kitchen1.setName("Японская");
		
		Kitchen kitchen2 = new Kitchen();
		kitchen2.setName("Китайская");
		
		Kitchen kitchen3 = new Kitchen();
		kitchen3.setName("Друидская");
		
		referenceService.save(kitchen1);
		referenceService.save(kitchen2);
		referenceService.save(kitchen3);
		
			
	}
	

	public void initRestaurant(){
		List<Category> categories = referenceService.getAll(Category.class);
		
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
