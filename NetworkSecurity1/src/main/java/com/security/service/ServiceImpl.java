package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.dao.DoctorRepositoryImpl;
import com.security.dao.NurseRepositoryImpl;
import com.security.dao.PatientRepositoryImpl;
import com.security.dao.RelativeRepositoryImpl;
import com.security.encryptionAlgorithm.Encryption;
import com.security.model.Doctor;
import com.security.model.DoctorPatient;
import com.security.model.Nurse;
import com.security.model.Patient;
import com.security.model.Relative;


@Service("securityService")
@Transactional(propagation = Propagation.REQUIRED)
public class ServiceImpl {

	@Autowired
	private DoctorRepositoryImpl doctorRepo;
	
	@Autowired
	private NurseRepositoryImpl nurseRepo;
	
	@Autowired
	private PatientRepositoryImpl patientRepo;
	
	@Autowired
	private RelativeRepositoryImpl relativeRepo;
	
	public boolean doctorLogin(String userName,String password){
		Doctor doctor=doctorRepo.findDoctor(userName);
		if(doctor!=null) {
			if(doctor.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	public boolean patientLogin(String userName,String password) {
		Patient patient=patientRepo.findPatient(userName);
		if(patient!=null) {
			if(patient.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	public boolean nurseLogin(String userName,String password) {
		Nurse nurse=nurseRepo.findNurse(userName);
		if(nurse!=null) {
			if(nurse.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	public boolean relativeLogin(String userName,String password) {
		Relative relative=relativeRepo.findRelative(userName);
		if(relative!=null) {
			if(relative.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	
	public void giveAuthorizationToDoctor(String doctorUserName,String patientUserName) {
		Doctor doctor=doctorRepo.findDoctor(doctorUserName);
		Patient patient=patientRepo.findPatient(patientUserName);
		DoctorPatient authorization=new DoctorPatient(doctor,patient);
		patient.addDoctor(authorization);
	}
	
}
