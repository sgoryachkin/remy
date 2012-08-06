package org.sg.remy.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.sg.remy.business.entity.Category;
import org.sg.remy.business.model.CategoryFilter;
import org.sg.remy.business.service.CategoryService;
import org.sg.remy.web.model.Menu;
import org.sg.remy.web.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController extends ViewPreparerSupport{
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private HttpServletRequest request;
	

    @Override
    public void execute(TilesRequestContext tilesContext,
                        AttributeContext attributeContext) {
    	
    	Map<Long, List<Category>> categoryMap = categoryService.findGroupe(new CategoryFilter(null, true, null, false));

    	List<Menu> menus = new ArrayList<Menu>();
    	for (Entry<Long, List<Category>> entry: categoryMap.entrySet()) {
    		List<Category> categories = entry.getValue();
    		
        	Menu menu = new Menu();
        	List<MenuItem> menuItems = new ArrayList<MenuItem>();
        	for (Category ref : categories) {
    			MenuItem menuItem = new MenuItem();
    			menuItem.setName(ref.getName());
    			menuItem.setUrl(request.getContextPath() + "/dispatcher/restaurant/find?page=1&amp;category=" + ref.getId());
    			menuItems.add(menuItem);
    		}
        	menu.setName(entry.getValue().iterator().next().getCategoryType().getName());
        	menu.setItems(menuItems);
        	menus.add(menu);
			
		}
    	
    	//LOG.debug("menu");
        // Get access to model parameters from MainController as example
        //String message = (String) tilesContext.getRequestScope().get("message");
    	

        tilesContext.getRequestScope().put("menus", menus);

    }

}
