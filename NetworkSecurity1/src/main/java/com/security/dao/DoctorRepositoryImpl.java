package com.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Doctor;


@Repository
@Transactional(readOnly = true)
public class DoctorRepositoryImpl implements DoctorRepositoryInterface {
	@PersistenceContext
	EntityManager entityManager;
	
	public Doctor findDoctor(String userName) {
		Query eventQuery = entityManager.createQuery("Select d from Doctor d where d.username=:userName ");
		eventQuery.setParameter("userName",userName );
		return (Doctor) eventQuery.getSingleResult();
		}
}
