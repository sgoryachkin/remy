package org.sg.remy.web.controller;

import java.util.List;

import org.sg.remy.business.entity.Product;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.business.service.RestaurantService;
import org.sg.remy.business.service.action.FindProduct;
import org.sg.remy.common.command.api.ActionService;
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
	
	@Autowired
	ActionService actionService;

	private static Logger LOG = LoggerFactory.getLogger(Product.class);

	public static final String MAPPING_ADD = "add";
	public static final String MAPPING_LIST = "find";
	public static final String MAPPING_SHOW = "show";

	@RequestMapping(value = MAPPING_LIST, method = RequestMethod.GET)
	public PagingResult<Product> find(
			@RequestParam(required = true, defaultValue = "1l") Long page,
			@RequestParam(required = false) List<Long> category){

		ProductFilter restaurantFilter = new ProductFilter();
		restaurantFilter.setCategoryIds(category);
		PagingParam<ProductFilter> param = new PagingParam<ProductFilter>(
				page, 10l, restaurantFilter);

		return actionService.doAction(new FindProduct(param));
	}

	@RequestMapping(value = MAPPING_SHOW, method = RequestMethod.GET)
	public Product show(@RequestParam Long id) {
		return restaurantService.get(id);
	}

	@RequestMapping(value = MAPPING_ADD, method = RequestMethod.POST)
	public String add(Product restaurant) {
		return MAPPING_SHOW;
	}

}
