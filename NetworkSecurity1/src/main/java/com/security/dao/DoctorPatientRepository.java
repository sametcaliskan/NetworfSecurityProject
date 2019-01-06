package com.security.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.security.model.DoctorPatient;
@Repository("doctorPatientRepository")
public interface DoctorPatientRepository extends JpaRepository<DoctorPatient,Long>,DoctorPatientRepositoryInterface{

	

}
