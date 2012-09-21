package org.sg.remy.dev;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.sg.remy.business.entity.Albom;
import org.sg.remy.business.entity.Product;
import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.service.action.Save;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDBComponent {
	
	@PersistenceContext
	EntityManager em;
	

	private List<ProductCategoryGroup> getAllProductCategoryGroup() {
		CriteriaQuery<ProductCategoryGroup> cq = em.getCriteriaBuilder().createQuery(ProductCategoryGroup.class);
		cq.from(ProductCategoryGroup.class);
		return em.createQuery(cq).getResultList();
	}
	
	private List<ProductCategory> getAllProductCategory() {
		CriteriaQuery<ProductCategory> cq = em.getCriteriaBuilder().createQuery(ProductCategory.class);
		cq.from(ProductCategory.class);
		return em.createQuery(cq).getResultList();
	}
	
	@Autowired
	CommandActionService commandService;
	

	@PostConstruct
	public void init(){
		initCategoryType();
		initCategory();
		initRestaurant();
	}
	
	private void initCategoryType(){
		ProductCategoryGroup categoryType = new ProductCategoryGroup();
		categoryType.setName("Тип заведения");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		commandService.doAction(new Save(categoryType));
		
		categoryType = new ProductCategoryGroup();
		categoryType.setName("Кухня");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		commandService.doAction(new Save(categoryType));
		
		categoryType = new ProductCategoryGroup();
		categoryType.setName("Средний чек");
		categoryType.setMultiple(false);
		categoryType.setShowable(true);
		commandService.doAction(new Save(categoryType));
		
		categoryType = new ProductCategoryGroup();
		categoryType.setName("Услуги");
		categoryType.setMultiple(true);
		categoryType.setShowable(true);
		commandService.doAction(new Save(categoryType));
		
	}
	
	private void initCategory(){
		
		List<ProductCategoryGroup> categoryTypes = getAllProductCategoryGroup();
		
		Iterator<ProductCategoryGroup> cti = categoryTypes.iterator();
		ProductCategoryGroup categoryType = cti.next();
		
		ProductCategory category = new ProductCategory();
		category.setName("Бары");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setShowable(true);
		category.setName("Кафе");
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Доставка");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Заведения 18+");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Рестораны");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Fast Food");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Клубы");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		categoryType = cti.next();
		
		category = new ProductCategory();
		category.setName("Японская");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Корейская");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));

		
		categoryType = cti.next();
		
		category = new ProductCategory();
		category.setName("Дорого");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Средне");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Дешево");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		categoryType = cti.next();
		
		category = new ProductCategory();
		category.setName("Караоке");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Живая музыка");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Летняя площадка");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Детские программы");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
		
		category = new ProductCategory();
		category.setName("Выездное обслуживание");
		category.setShowable(true);
		category.setProductCategoryGroup(categoryType);
		commandService.doAction(new Save(category));
				
		
	}
	

	private void initRestaurant(){
		List<ProductCategory> categories = getAllProductCategory();
		System.out.println(categories);
		
		for (int i = 0; i < 11; i++) {
			Product r = new Product();
			r.setCategories(categories);
			r.setName("Заведение " + i);
			r.setDescription("Описание для заведения");
			Albom albom = new Albom();
			albom.setAlbomId("5771783291887167073");
			albom.setUserId("artful.tiger");
			r.setGallery(albom);
			commandService.doAction(new Save(r));
			
		}

	}

}
