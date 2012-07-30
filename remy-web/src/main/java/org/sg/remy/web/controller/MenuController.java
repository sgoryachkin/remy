package org.sg.remy.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.sg.remy.business.entity.Category;
import org.sg.remy.business.entity.Kitchen;
import org.sg.remy.business.entity.Reference;
import org.sg.remy.business.service.ReferenceService;
import org.sg.remy.web.model.Menu;
import org.sg.remy.web.model.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController extends ViewPreparerSupport{
	
	private static Logger LOG = LoggerFactory.getLogger(MenuController.class); 
	
	@Autowired
	private ReferenceService referenceService;
	
	@Autowired
	private HttpServletRequest request;
	

    @Override
    public void execute(TilesRequestContext tilesContext,
                        AttributeContext attributeContext) {

    	//LOG.debug("menu");
        // Get access to model parameters from MainController as example
        //String message = (String) tilesContext.getRequestScope().get("message");
    	
    	List<Category> categories = referenceService.getAllNoEmpty(Category.class);
    	List<Kitchen> kitchens = referenceService.getAllNoEmpty(Kitchen.class);
    	
    	List<Menu> menus = new ArrayList<Menu>();
    	
    	Menu menu = new Menu();
    	List<MenuItem> menuItems = new ArrayList<MenuItem>();
    	for (Reference ref : categories) {
			MenuItem menuItem = new MenuItem();
			menuItem.setName(ref.getName());
			menuItem.setUrl(request.getContextPath() + "/dispatcher/restaurant/find?page=1&category=" + ref.getId());
			menuItems.add(menuItem);
		}
    	menu.setName("Категории");
    	menu.setItems(menuItems);
    	menus.add(menu);
    	
    	menu = new Menu();
    	menuItems = new ArrayList<MenuItem>();
    	for (Reference ref : kitchens) {
			MenuItem menuItem = new MenuItem();
			menuItem.setName(ref.getName());
			menuItem.setUrl(request.getContextPath() + "/dispatcher/restaurant/find?page=1&kitchens=" + ref.getId());
			menuItems.add(menuItem);
		}
    	menu.setName("Кухни");
    	menu.setItems(menuItems);
    	menus.add(menu);

        tilesContext.getRequestScope().put("menus", menus);

    }

}
