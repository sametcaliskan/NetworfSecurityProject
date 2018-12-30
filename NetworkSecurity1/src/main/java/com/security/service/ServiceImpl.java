package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.dao.DoctorRepository;
import com.security.dao.NurseRepository;
import com.security.dao.PatientRepository;
import com.security.dao.RelativeRepository;
import com.security.encryptionAlgorithm.Encryption;
import com.security.model.Doctor;
import com.security.model.DoctorPatient;
import com.security.model.Nurse;
import com.security.model.NursePatient;
import com.security.model.Patient;
import com.security.model.Relative;


@Service("securityService")
@Transactional(propagation = Propagation.REQUIRED)
public class ServiceImpl implements SecurityServiceInterface {

	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private NurseRepository nurseRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private RelativeRepository relativeRepo;
	
	@Override
	public boolean doctorLogin(String userName,String password){
		Doctor doctor=doctorRepo.findDoctor(userName);
		if(doctor!=null) {
			if(doctor.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	@Override
	public boolean patientLogin(String userName,String password) {
		System.out.println("hereee");
		Patient patient=patientRepo.findPatient(userName);
		if(patient!=null) {
			if(patient.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	@Override
	public boolean nurseLogin(String userName,String password) {
		Nurse nurse=nurseRepo.findNurse(userName);
		if(nurse!=null) {
			if(nurse.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	@Override
	public boolean relativeLogin(String userName,String password) {
		Relative relative=relativeRepo.findRelative(userName);
		if(relative!=null) {
			if(relative.getPassword()==Encryption.sha256Encrypt(password)) {
				return true;}
			return false;
		}
		return false;
	}
	@Override
	public void giveAuthorizationToDoctor(String doctorUserName,String patientUserName) {
		Doctor doctor=doctorRepo.findDoctor(doctorUserName);
		Patient patient=patientRepo.findPatient(patientUserName);
		DoctorPatient authorization=new DoctorPatient(doctor,patient);
		patient.addDoctor(authorization);
		doctor.addPatient(authorization);
	}
	@Override
	public void giveAuthorizationToNurse(String nurseUserName,String patientUserName) {
		Nurse nurse=nurseRepo.findNurse(nurseUserName);
		Patient patient=patientRepo.findPatient(patientUserName);
		NursePatient authorization=new NursePatient(nurse,patient);
		nurse.addPatient(authorization);
		patient.addNurse(authorization);
	}
	@Override
	public List<Patient> getAllPatients() {
		return patientRepo.findAll();
	}
	@Override
	public Patient getPatientByUsername(String username) {
		return patientRepo.findPatient(username);
		
	}
	@Override
	public Doctor getDoctorByUsername(String username) {
		return doctorRepo.findDoctor(username);
	}
	@Override
	public Patient addPatient(String name, String surname, String birthday, String diagnostic) {
		String password=Encryption.createPassword();
		Patient patient=new Patient(name,surname,birthday,diagnostic);
		patient.setPassword(password);
		String username=name+surname;
		if((patientRepo.findPatient(username))==null) {
		patientRepo.save(patient);
		}
		else {
			username=Encryption.createUsername(username);
			patient.setUserName(username);
			patientRepo.save(patient);
		}
		return patient;
	}
	
}
