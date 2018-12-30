package com.security.dao;

import com.security.model.Doctor;

public interface DoctorRepositoryInterface {
	public Doctor findDoctor(String userName);
}
