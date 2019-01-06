package com.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.security.model.Doctor;
import com.security.model.Patient;



public class DoctorPatientRepositoryImpl implements DoctorPatientRepositoryInterface{
	@PersistenceContext
	EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getPatientDoctors(Long id) {
		Query eventQuery = entityManager.createQuery("Select d.doctor from DoctorPatient d where d.patient.id=:id");
		eventQuery.setParameter("id",id );
		List<Doctor> result=eventQuery.getResultList();
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatients(Long id) {
		try {
		Query eventQuery = entityManager.createQuery("Select d.patient from DoctorPatient d where d.doctor.id=:id");
		eventQuery.setParameter("id",id );
		List<Patient> result=eventQuery.getResultList();
		return result;
		
		} catch (Exception e) {
			return null;
		}
	}



}
