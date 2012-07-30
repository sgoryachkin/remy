package org.sg.remy.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.sg.remy.business.entity.Reference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReferenceServiceImpl implements ReferenceService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Reference category) {
		em.persist(category);
		
	}

	@Override
	public <T extends Reference> T get(Class<T> clazz, Long id) {
		return em.find(clazz, id);
	}

	@Override
	public <T extends Reference> List<T> getAll(Class<T> clazz) {
		CriteriaQuery<T> c = em.getCriteriaBuilder().createQuery(clazz);
		c.from(clazz);
		return em.createQuery(c).getResultList();
	}

	@Override
	public <T extends Reference> List<T> getAllNoEmpty(Class<T> clazz) {
		// TODO Нужна реализация выбора не пустых справочников
		return getAll(clazz);
	}

}
