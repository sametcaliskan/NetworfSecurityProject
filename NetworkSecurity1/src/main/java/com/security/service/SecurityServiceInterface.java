package com.security.service;

import java.util.List;

import com.security.model.Doctor;
import com.security.model.Patient;

public interface SecurityServiceInterface {
	public boolean doctorLogin(String userName,String password);
	public boolean patientLogin(String userName,String password);
	public boolean nurseLogin(String userName,String password);
	public boolean relativeLogin(String userName,String password);
	public void giveAuthorizationToDoctor(Long doctorId,Long patientId);
	public void giveAuthorizationToNurse(Long nurseId,Long patientId);
	public List<Patient> getAllPatients() ;
	public Patient getPatientByUsername(String username);
	public Doctor getDoctorByUsername(String username);
	public Patient addPatient(String name, String surname, String birthday, String diagnostic);
	public void updateDoctor(Long id, String username, String password);
	public void updateNurse(Long id, String username, String password);
	public void updateRelative(Long id, String username, String password);
	public List<Doctor> getAllDoctors();
	public List<Doctor> getPatientDoctors(Long id);
	public void addRelative(String name, String surname, Long id);
	public void deleteRelative(Long id);
}
