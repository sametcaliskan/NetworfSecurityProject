package com.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Relative;

@Repository
@Transactional(readOnly = true)
public class RelativeRepositoryImpl implements RelativeRepositoryInterface{
	@PersistenceContext
	EntityManager entityManager;

	
	public Relative findRelative(String userName) {
		Query eventQuery = entityManager.createQuery("Select d from Relative d where d.username=:userName ");
		eventQuery.setParameter("userName",userName );
		return (Relative) eventQuery.getSingleResult();
		}
}

