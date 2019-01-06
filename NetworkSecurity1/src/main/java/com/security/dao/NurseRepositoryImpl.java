package com.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Nurse;

@Repository
@Transactional(readOnly = true)
public class NurseRepositoryImpl implements NurseRepositoryInterface{
	@PersistenceContext
	EntityManager entityManager;

	public Nurse getNurseByUsername(String userName) {
		Query eventQuery = entityManager.createQuery("Select d from Nurse d where d.userName=:userName ");
		eventQuery.setParameter("userName",userName );
		return (Nurse) eventQuery.getSingleResult();
		}
}

