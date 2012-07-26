package org.sg.remy.business.service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sg.remy.business.entity.Restaurant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InitDBServiceImpl {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void initDB() {
		Restaurant r = new Restaurant();
		em.persist(r);
		System.out.println(r.getId());
		System.out.println(em.contains(r));
		
		Restaurant r2 = new Restaurant();
		r2.setId(r.getId());
		System.out.println(em.contains(r2));
		
	}

}
