package org.sg.remy.business.service.handler;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.service.action.Save;
import org.sg.remy.common.command.api.ActionHandler;
import org.sg.remy.common.command.api.Handler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Handler(action = Save.class)
public class SaveHandler implements ActionHandler<Save, Void> {

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
