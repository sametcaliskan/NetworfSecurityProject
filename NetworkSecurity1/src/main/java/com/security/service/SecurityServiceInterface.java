package com.security.service;

import java.util.List;

import com.security.model.Doctor;
import com.security.model.Patient;

public interface SecurityServiceInterface {
	public boolean doctorLogin(String userName,String password);
	public boolean patientLogin(String userName,String password);
	public boolean nurseLogin(String userName,String password);
	public boolean relativeLogin(String userName,String password);
	public void giveAuthorizationToDoctor(String doctorUserName,String patientUserName);
	public void giveAuthorizationToNurse(String nurseUserName,String patientUserName);
	public List<Patient> getAllPatients() ;
	public Patient getPatientByUsername(String username);
	public Doctor getDoctorByUsername(String username);
	public Patient addPatient(String name, String surname, String birthday, String diagnostic);
}
