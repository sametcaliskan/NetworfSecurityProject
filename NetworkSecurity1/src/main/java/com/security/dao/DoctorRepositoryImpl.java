package com.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Doctor;
import com.security.model.Nurse;


@Repository
@Transactional(readOnly = true)
public class DoctorRepositoryImpl implements DoctorRepositoryInterface {
	@PersistenceContext
	EntityManager entityManager;
	
	public Doctor findDoctor(String userName) {
		Query eventQuery = entityManager.createQuery("Select d from Doctor d where d.userName=:userName ");
		eventQuery.setParameter("userName",userName );
		return (Doctor) eventQuery.getSingleResult();
		}
	@SuppressWarnings("unchecked")
	@Override
	public List<Nurse> getDoctorNurses(Long id) {
			try {
				Query eventQuery = entityManager.createQuery("Select d.nurses from Doctor d where d.id=:id");
				eventQuery.setParameter("id",id );
				List<Nurse> result=eventQuery.getResultList();
				return result;
				
				} catch (Exception e) {
					return null;
				}
	}

}
