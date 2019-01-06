package com.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Patient;

@Repository
@Transactional(readOnly = true)
public class PatientRepositoryImpl implements PatientRepositoryInterface{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Patient findPatient(String userName) {
		Query eventQuery = entityManager.createQuery("Select d from Patient d where d.username=:userName ");
		eventQuery.setParameter("userName",userName );
		return (Patient) eventQuery.getSingleResult();
		}
}


