package org.sg.remy.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "misc")
public class WelcomeController {
	
	private static Logger LOG = LoggerFactory.getLogger(WelcomeController.class); 
	
	@RequestMapping(value = "welcome", method=RequestMethod.GET)
	public void welcome(){
		LOG.debug("welcome");
	}
	
}
 