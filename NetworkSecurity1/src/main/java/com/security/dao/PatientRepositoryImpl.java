package com.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Patient;
import com.security.model.Relative;

@Repository
@Transactional(readOnly = true)
public class PatientRepositoryImpl implements PatientRepositoryInterface{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Patient findPatient(String userName) {
		try {
			Query eventQuery = entityManager.createQuery("Select d from Patient d where d.userName=:userName ");
			eventQuery.setParameter("userName",userName );
			return (Patient) eventQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
		}
}


