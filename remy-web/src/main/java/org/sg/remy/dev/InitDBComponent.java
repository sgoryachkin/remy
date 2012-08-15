package org.sg.remy.dev;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.sg.remy.business.entity.Albom;
import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.entity.Product;
import org.sg.remy.business.model.CategoryFilter;
import org.sg.remy.business.service.CategoryService;
import org.sg.remy.business.service.CategoryTypeService;
import org.sg.remy.business.service.RestaurantService;
import org.sg.remy.business.service.action.Save;
import org.sg.remy.common.command.api.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDBComponent {
	
	@Autowired
	ActionService commandService;
	
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
		ProductCategoryGroup categoryType = new ProductCategoryGroup();
		categoryType.setName("Тип заведения");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		commandService.doAction(new Save(categoryType));
		
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
		List<ProductCategory> categories = referenceService.find(new CategoryFilter());
		
		for (int i = 0; i < 151; i++) {
			Product r = new Product();
			r.setCategories(categories);
			r.setName("Заведение " + i);
			r.setDescription("Описание для заведения");
			r.setCategories(categories);
			Albom albom = new Albom();
			albom.setAlbomId("5771783291887167073");
			albom.setUserId("artful.tiger");
			r.setGallery(albom);
			restaurantService.save(r);
			
		}

	}

}
