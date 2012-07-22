package org.sg.remy.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "restaurant")
public class WelcomeController {
	
	private static Logger LOG = LoggerFactory.getLogger(WelcomeController.class); 
	
	@RequestMapping(value = "welcome")
	public void welcome(){
		LOG.debug("welcome");
	}
	
}
