package com.security.service;

import java.util.List;

import com.security.model.Doctor;
import com.security.model.DoctorPatient;
import com.security.model.Nurse;
import com.security.model.NursePatient;
import com.security.model.Patient;
import com.security.model.Relative;

public interface SecurityServiceInterface {
	public boolean doctorLogin(String userName,String password);
	public boolean patientLogin(String userName,String password);
	public boolean nurseLogin(String userName,String password);
	public boolean relativeLogin(String userName,String password);
	public DoctorPatient giveAuthorizationToDoctor(Long doctorId,Long patientId);
	public NursePatient giveAuthorizationToNurse(Long nurseId,Long patientId);
	public List<Patient> getAllPatients() ;
	public Patient getPatientByUsername(String username);
	public Doctor getDoctorByUsername(String username);
	public Patient addPatient(String name, String surname, String birthday, String diagnostic);
	public Doctor updateDoctor(Long id, String username, String password);
	public Nurse updateNurse(Long id, String username, String password);
	public Relative updateRelative(Long id, String username, String password);
	public List<Doctor> getAllDoctors();
	public List<Doctor> getPatientDoctors(Long id);
	public Relative addRelative(String name, String surname, Long id);
	public void deleteRelative(Long id);
	public List<Patient> getDoctorPatient(Long id);
	public DoctorPatient addDoctorPatient(Doctor doctor,Patient patient);
	public List<Nurse> getDoctorNurses(Long id);
	public Nurse getNurseByUsername(String username);
	public Relative getRelativeByUsername(String username);
	public List<Patient> getNursePatients(Long id);
	public Relative getRelativeOfPatient(Long id);
	public List<Nurse> getPatientNurses(Long id);
}
