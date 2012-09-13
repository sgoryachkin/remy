package org.sg.remy.web.controller;

import org.sg.remy.business.entity.ProductCategoryGroup;
import org.sg.remy.business.service.action.SaveProductCategoryGroup;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "categorygroup")
public class CategoryGroupController {
	
	private static Logger LOG = LoggerFactory.getLogger(CategoryGroupController.class); 
	
	@Autowired
	CommandActionService actionService;
	
	@RequestMapping(value = "edit", method=RequestMethod.POST)
	public String save(@ModelAttribute("productCategoryGroup") ProductCategoryGroup productCategoryGroup, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
        	actionService.doAction(new SaveProductCategoryGroup(productCategoryGroup));
            return "redirect:/";
        } else {
            return "";
        }
            
    }
	
	@RequestMapping(value = "edit", method=RequestMethod.GET)
	public void get()
    {

    }
	
}
 