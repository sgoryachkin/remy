package org.sg.remy.web.controller;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.sg.remy.business.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController extends ViewPreparerSupport{
	
	private static Logger LOG = LoggerFactory.getLogger(MenuController.class); 
	
	@Autowired
	private CategoryService categoryService;

    @Override
    public void execute(TilesRequestContext tilesContext,
                        AttributeContext attributeContext) {

    	//LOG.debug("menu");
        // Get access to model parameters from MainController as example
        //String message = (String) tilesContext.getRequestScope().get("message");

        tilesContext.getRequestScope().put("categories", categoryService.getAll());

    }

}
