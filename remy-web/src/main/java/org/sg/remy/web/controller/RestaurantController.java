package org.sg.remy.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.sg.remy.business.entity.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value= "restaurant")
public class RestaurantController {
	
	private static Logger LOG = LoggerFactory.getLogger(Restaurant.class);

	public static final String MAPPING_ADD = "add";
	public static final String MAPPING_LIST = "find";
	public static final String MAPPING_SHOW = "welcome";
	
	
	@RequestMapping(value = MAPPING_LIST)
	public List<Restaurant> find(){
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		return restaurants;
	}
	
	//@RequestMapping(value = MAPPING_SHOW, method = RequestMethod.GET)
	@RequestMapping
	public Restaurant show(@RequestParam("id") String id){
		LOG.info("dd");
		return null;
	}


	@RequestMapping(value = MAPPING_ADD, method = RequestMethod.POST)
	public String add(Restaurant restaurant){
		return MAPPING_SHOW;
	}
	
}
