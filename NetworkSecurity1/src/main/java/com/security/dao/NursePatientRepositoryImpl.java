package com.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.security.model.Nurse;
import com.security.model.Patient;


public class NursePatientRepositoryImpl implements NursePatientRepositoryInterface {
	@PersistenceContext
	EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getNursePatients(Long id) {
		try {
			Query eventQuery = entityManager.createQuery("Select d.patient from NursePatient d where d.nurse.id=:id");
			eventQuery.setParameter("id",id );
			List<Patient> result=eventQuery.getResultList();
			return result;
			
			} catch (Exception e) {
				return null;
			}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Nurse> getPatientNurses(Long id) {
		try {
			Query eventQuery = entityManager.createQuery("Select d.nurse from NursePatient d where d.patient.id=:id");
			eventQuery.setParameter("id",id );
			List<Nurse> result=eventQuery.getResultList();
			return result;
			
			} catch (Exception e) {
				return null;
			}
	}

}
