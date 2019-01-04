package com.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.security.model.Doctor;

public class DoctorPatientRepositoryImpl implements DoctorPatientRepositoryInterface{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Long> getDoctorPatient(Long id) {
		Query eventQuery = entityManager.createQuery("Select d.doctorId from DoctorPatient d where d.patientId.id=:id");
		eventQuery.setParameter("id",id );
		List<Long> result=eventQuery.getResultList();
		return result;
	}



}
