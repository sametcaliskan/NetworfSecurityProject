package com.security.dao;

import com.security.model.Patient;

public interface PatientRepositoryInterface {
	public Patient findPatient(String userName);
}
