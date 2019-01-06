package com.security.dao;

import java.util.List;

import com.security.model.Nurse;
import com.security.model.Patient;

public interface NursePatientRepositoryInterface {

	List<Patient> getNursePatients(Long id);
	
	List<Nurse> getPatientNurses(Long id);
}
