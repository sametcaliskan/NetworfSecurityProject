package com.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Nurse;
import com.security.model.NursePatient;
import com.security.model.Patient;

@Repository("nursePatientRepository")
public interface NursePatientRepository extends JpaRepository<NursePatient,Long>, NursePatientRepositoryInterface {

	

	

	

}
