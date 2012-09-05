package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.service.action.Save;
import org.sg.remy.common.cmd.api.CommandHandler;
import org.sg.remy.common.cmd.api.HandlerFor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@HandlerFor(Save.class)
public class SaveHandler implements CommandHandler<Save, Void> {

	@PersistenceContext
	EntityManager em;

	@Override
	public Void execute(Save command) {
		for (Object object : command.getObjects()) {
			em.persist(object);
		}
		return null;
	}

}
