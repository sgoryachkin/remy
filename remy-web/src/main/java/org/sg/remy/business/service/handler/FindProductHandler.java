package org.sg.remy.business.service.handler;

import java.util.LinkedList;
import java.util.List;

import org.sg.remy.business.entity.Listable;
import org.sg.remy.business.model.PagingParam;
import org.sg.remy.business.model.PagingResult;
import org.sg.remy.business.model.PagingResultImpl;
import org.sg.remy.business.model.ProductFilter;
import org.sg.remy.business.service.action.FindProduct;
import org.sg.remy.business.service.action.FindProductIds;
import org.sg.remy.business.service.action.GetListable;
import org.sg.remy.common.cmd.api.CommandActionService;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(FindProduct.class)
public class FindProductHandler implements CommandHandler<FindProduct, PagingResult<Listable>>{
	
	@Autowired
	CommandActionService actionService;

	@Override
	public PagingResult<Listable> execute(FindProduct findProduct) {
		
		PagingParam<ProductFilter> param = findProduct.getPagingParam();
		
		PagingResult<Long> ids = actionService.doAction(new FindProductIds(param));
		
		PagingResultImpl<Listable> pagingResult = new PagingResultImpl<Listable>();
		pagingResult.setPage(param.getPage());
		pagingResult.setCount(ids.getCount());
		pagingResult.setPageCount(ids.getPageCount());
		
		List<Listable> listables = new LinkedList<Listable>();
		for (Long id : ids.getResult()) {
			Listable listable = actionService.doAction(new GetListable(id));
			listables.add(listable);
		}
		
		pagingResult.setResult(listables);
		return pagingResult;
	}

}
