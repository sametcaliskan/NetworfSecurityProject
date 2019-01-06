package com.security.dao;

import java.util.List;

import com.security.model.Doctor;
import com.security.model.Patient;


public interface DoctorPatientRepositoryInterface {
	List<Doctor> getPatientDoctors(Long id);
	List<Patient> getPatients(Long id);
}
