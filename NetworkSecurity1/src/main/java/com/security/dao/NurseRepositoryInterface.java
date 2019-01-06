package com.security.dao;


import com.security.model.Nurse;

public interface NurseRepositoryInterface {
	public Nurse getNurseByUsername(String userName);
}
