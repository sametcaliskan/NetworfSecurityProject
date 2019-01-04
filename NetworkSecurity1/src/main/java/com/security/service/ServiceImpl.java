package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.dao.DoctorPatientRepository;
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


@Service
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
	
	@Autowired
	private DoctorPatientRepository doctorPatientRepo;
	@Override
	public boolean doctorLogin(String userName,String password){
		try {
			Doctor doctor=doctorRepo.findDoctor(userName);
			if(doctor.getPassword()==password) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
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
	public void giveAuthorizationToDoctor(Long doctorId,Long patientId) {
		Doctor doctor=doctorRepo.findOne(doctorId);
		Patient patient=patientRepo.findOne(patientId);
		DoctorPatient authorization=new DoctorPatient(doctor,patient);
		patient.addDoctor(authorization);
		doctor.addPatient(authorization);
	}
	@Override
	public void giveAuthorizationToNurse(Long nurseId,Long patientId) {
		Nurse nurse=nurseRepo.findOne(nurseId);
		Patient patient=patientRepo.findOne(patientId);
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
	@Override
	public void updateDoctor(Long id, String username, String password) {
		Doctor doctor=doctorRepo.findOne(id);
		doctor.setUserName(username);
		doctor.setPassword(password);
	}
	@Override
	public void updateNurse(Long id, String username, String password) {
		Nurse nurse=nurseRepo.findOne(id);
		nurse.setUserName(username);
		nurse.setPassword(password);
	}
	@Override
	public void updateRelative(Long id, String username, String password) {
		Relative relative=relativeRepo.findOne(id);
		relative.setUsername(username);
		relative.setPassword(password);
	}
	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepo.findAll();
	}
	@Override
	public List<Doctor> getPatientDoctors(Long id) {
		List<Long> doctorsId=doctorPatientRepo.getDoctorPatient(id);
		List<Doctor> doctors=new ArrayList<>();
		for(Long idd:doctorsId) {
			Doctor doctor=doctorRepo.findOne(idd);
			doctors.add(doctor);
		}
		return doctors;
	}
	@Override
	public void addRelative(String name, String surname, Long id) {
		Relative relative=new Relative(name,surname);
		Patient patient=patientRepo.findOne(id);
		patient.setRelative(relative);
		
	}
	@Override
	public void deleteRelative(Long id) {
		relativeRepo.delete(id);
	}
	
}
