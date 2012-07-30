package org.sg.remy.web.controller;

import java.util.List;

import org.sg.remy.business.entity.Restaurant;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.RestaurantFilter;
import org.sg.remy.business.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	private static Logger LOG = LoggerFactory.getLogger(Restaurant.class);

	public static final String MAPPING_ADD = "add";
	public static final String MAPPING_LIST = "find";
	public static final String MAPPING_SHOW = "welcome";

	@RequestMapping(value = MAPPING_LIST, method = RequestMethod.GET)
	public PagingResult<Restaurant> find(
			@RequestParam(required = true, defaultValue = "1l") Long page,
			@RequestParam(required = false) List<Long> category){

		RestaurantFilter restaurantFilter = new RestaurantFilter();
		restaurantFilter.setCategoryIds(category);
		PagingParam<RestaurantFilter> param = new PagingParam<RestaurantFilter>(
				page, 10l, restaurantFilter);

		return restaurantService.find(param);
	}

	// @RequestMapping(value = MAPPING_SHOW, method = RequestMethod.GET)
	@RequestMapping
	public Restaurant show(@RequestParam("id") String id) {
		LOG.info("dd");
		return null;
	}

	@RequestMapping(value = MAPPING_ADD, method = RequestMethod.POST)
	public String add(Restaurant restaurant) {
		return MAPPING_SHOW;
	}

}
