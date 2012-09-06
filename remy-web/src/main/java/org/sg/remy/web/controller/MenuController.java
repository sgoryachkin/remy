package org.sg.remy.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.sg.remy.business.entity.ProductCategory;
import org.sg.remy.business.model.ProductCategoryFilter;
import org.sg.remy.business.service.action.FindProductCategory;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.sg.remy.web.model.Menu;
import org.sg.remy.web.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController extends ViewPreparerSupport{
	
	@Autowired
	private CommandActionService actionService;
	
	@Autowired
	private HttpServletRequest request;
	

    @Override
    public void execute(TilesRequestContext tilesContext,
                        AttributeContext attributeContext) {
    	
    	Collection<ProductCategory> categories = actionService.doAction(new FindProductCategory(new ProductCategoryFilter(null, true, null)));
    	
    	Map<Long, List<ProductCategory>> categoryMap = findGroupe(categories);

    	List<Menu> menus = new ArrayList<Menu>();
    	for (Entry<Long, List<ProductCategory>> entry: categoryMap.entrySet()) {
    		List<ProductCategory> categoriesGroup = entry.getValue();
    		
        	Menu menu = new Menu();
        	List<MenuItem> menuItems = new ArrayList<MenuItem>();
        	for (ProductCategory ref : categoriesGroup) {
    			MenuItem menuItem = new MenuItem();
    			menuItem.setName(ref.getName());
    			menuItem.setUrl(request.getContextPath() + "/dispatcher/restaurant/find?page=1&amp;category=" + ref.getId());
    			menuItem.setCount(ref.getProductCount());
    			menuItems.add(menuItem);
    		}
        	menu.setName(entry.getValue().iterator().next().getProductCategoryGroup().getName());
        	menu.setItems(menuItems);
        	menus.add(menu);
			
		}
    	
    	//LOG.debug("menu");
        // Get access to model parameters from MainController as example
        //String message = (String) tilesContext.getRequestScope().get("message");
    	

        tilesContext.getRequestScope().put("menus", menus);

    }
    
	private Map<Long, List<ProductCategory>> findGroupe(Collection<ProductCategory> categories) {
		Map<Long, List<ProductCategory>> result = new LinkedHashMap<Long, List<ProductCategory>>();
		for (ProductCategory category : categories) {
			Long categpryId = category.getProductCategoryGroup().getId();
			List<ProductCategory> group = result.get(categpryId);
			if (group == null) {
				group = new ArrayList<ProductCategory>();
				result.put(categpryId, group);
			}
			group.add(category);
		}
		return result;
	}

}
