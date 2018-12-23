package com.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Nurse;

@Repository
@Transactional(readOnly = true)
public class NurseRepositoryImpl {
	@PersistenceContext
	EntityManager entityManager;

	public Nurse findNurse(String userName) {
		Query eventQuery = entityManager.createQuery("Select d from Nurse d where d.username=:userName ");
		eventQuery.setParameter("userName",userName );
		return (Nurse) eventQuery.getSingleResult();
		}
}

