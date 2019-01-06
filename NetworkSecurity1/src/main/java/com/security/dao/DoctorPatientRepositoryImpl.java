package com.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



public class DoctorPatientRepositoryImpl implements DoctorPatientRepositoryInterface{
	@PersistenceContext
	EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getDoctorPatient(Long id) {
		Query eventQuery = entityManager.createQuery("Select d.doctorId from DoctorPatient d where d.patientId.id=:id");
		eventQuery.setParameter("id",id );
		List<Long> result=eventQuery.getResultList();
		return result;
	}



}
