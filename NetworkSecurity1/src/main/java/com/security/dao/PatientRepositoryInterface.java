package com.security.dao;

import com.security.model.Patient;
import com.security.model.Relative;

public interface PatientRepositoryInterface {
	public Patient findPatient(String userName);

}
