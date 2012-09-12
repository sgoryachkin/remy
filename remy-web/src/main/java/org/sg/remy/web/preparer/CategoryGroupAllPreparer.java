package org.sg.remy.web.preparer;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparerSupport;
import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.service.action.FindAllProductCategoryGroup;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryGroupAllPreparer extends ViewPreparerSupport{
	
	public static final String PREFIX = "categorygroup_all";
	
	@Autowired
	private CommandActionService actionService;
	
	@Autowired
	private HttpServletRequest request;
	

    @Override
    public void execute(TilesRequestContext tilesContext,
                        AttributeContext attributeContext) {
    
    	Collection<ProductCategoryGroup> categoryGroups = actionService.doAction(new FindAllProductCategoryGroup());
    	tilesContext.getRequestScope().put(PREFIX, categoryGroups);

    }

}
