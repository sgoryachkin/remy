package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.entity.Listable;
import org.sg.remy.business.service.action.GetListable;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.Handler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Handler(action = GetListable.class)
public class GetListableHandler implements CommandHandler<GetListable, Listable>{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Listable execute(GetListable command) {
		Listable listable = em.find(Listable.class, command.getId());
		return listable;
	}



}
