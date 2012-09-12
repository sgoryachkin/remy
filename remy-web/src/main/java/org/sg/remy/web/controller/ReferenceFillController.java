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
@RequestMapping(value= "reference")
public class ReferenceFillController {
	
	private static Logger LOG = LoggerFactory.getLogger(ReferenceFillController.class); 
	
	@Autowired
	CommandActionService actionService;
	
	@RequestMapping(value = "categorygroup_edit", method=RequestMethod.POST)
	public void save(@ModelAttribute("productCategoryGroup") ProductCategoryGroup productCategoryGroup, BindingResult result, Model model)
    {
            actionService.doAction(new SaveProductCategoryGroup(productCategoryGroup));
    }
	
	@RequestMapping(value = "categorygroup_edit", method=RequestMethod.GET)
	public void get(@ModelAttribute("productCategoryGroup") ProductCategoryGroup productCategoryGroup, BindingResult result, Model model)
    {

    }
	
}
 