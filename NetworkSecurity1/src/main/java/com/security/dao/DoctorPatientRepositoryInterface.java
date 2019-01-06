package com.security.dao;

import java.util.List;


public interface DoctorPatientRepositoryInterface {
	List<Long> getDoctorPatient(Long id);
}
