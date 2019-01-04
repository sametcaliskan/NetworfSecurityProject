package com.security.dao;

import java.util.List;

import com.security.model.Doctor;

public interface DoctorPatientRepositoryInterface {
	List<Long> getDoctorPatient(Long id);
}
