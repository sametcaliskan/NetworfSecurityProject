package com.security.dao;

import java.util.List;

import com.security.model.Doctor;
import com.security.model.Nurse;

public interface DoctorRepositoryInterface {
	public Doctor findDoctor(String userName);
	List<Nurse> getDoctorNurses(Long id);
}
