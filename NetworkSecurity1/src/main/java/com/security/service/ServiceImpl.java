package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.dao.DoctorPatientRepository;
import com.security.dao.DoctorRepository;
import com.security.dao.NursePatientRepository;
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


@Service("SecurityService")
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
	
	@Autowired
	private NursePatientRepository nursePatientRepo;
	
	public DoctorRepository getDoctorRepo() {
		return doctorRepo;
	}
	public void setDoctorRepo(DoctorRepository doctorRepo) {
		this.doctorRepo = doctorRepo;
	}
	public NurseRepository getNurseRepo() {
		return nurseRepo;
	}
	public void setNurseRepo(NurseRepository nurseRepo) {
		this.nurseRepo = nurseRepo;
	}
	public PatientRepository getPatientRepo() {
		return patientRepo;
	}
	public void setPatientRepo(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}
	public RelativeRepository getRelativeRepo() {
		return relativeRepo;
	}
	public void setRelativeRepo(RelativeRepository relativeRepo) {
		this.relativeRepo = relativeRepo;
	}
	public DoctorPatientRepository getDoctorPatientRepo() {
		return doctorPatientRepo;
	}
	public void setDoctorPatientRepo(DoctorPatientRepository doctorPatientRepo) {
		this.doctorPatientRepo = doctorPatientRepo;
	}
	@Override
	public boolean doctorLogin(String userName,String password){
		try {
			Doctor doctor=doctorRepo.findDoctor(userName);
			if(doctor.getUserName().equals(userName)) {
				System.out.println("password is true");
				return true;
			}
			System.out.println("password is wrong");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	@Override
	public boolean patientLogin(String userName,String password) {
		Patient patient=patientRepo.findPatient(userName);
		if(patient!=null) {
			if(patient.getUserName().equals(userName)) {
				return true;}
			return false;
		}
		return false;
	}
	@Override
	public boolean nurseLogin(String userName,String password) {
		Nurse nurse=nurseRepo.getNurseByUsername(userName);
		if(nurse!=null) {
			if(nurse.getUserName().equals(userName)) {
				return true;}
			return false;
		}
		return false;
	}
	@Override
	public boolean relativeLogin(String userName,String password) {
		Relative relative=relativeRepo.findRelative(userName);
		if(relative!=null) {
			if(relative.getUserName().equals(userName)) {
				return true;}
			return false;
		}
		return false;
	}
	@Override
	public DoctorPatient giveAuthorizationToDoctor(Long doctorId,Long patientId) {
		Doctor doctor=doctorRepo.getOne(doctorId);
		Patient patient=patientRepo.getOne(patientId);
		DoctorPatient authorization=new DoctorPatient(doctor,patient);
		doctorPatientRepo.save(authorization);
		return authorization;
		//patient.addDoctor(authorization);
		//doctor.addPatient(authorization);
	}
	@Override
	public NursePatient giveAuthorizationToNurse(Long nurseId,Long patientId) {
		Nurse nurse=nurseRepo.getOne(nurseId);
		Patient patient=patientRepo.getOne(patientId);
		NursePatient authorization=new NursePatient(nurse,patient);
		nursePatientRepo.save(authorization);
		//nurse.addPatient(authorization);
		//patient.addNurse(authorization);
		return authorization;
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
		if(patientRepo.findPatient(username)==null) {
			System.out.println("savig");
		patientRepo.save(patient);
		System.out.println("saved");
		}
		else {
			username=Encryption.createUsername(username);
			patient.setUserName(username);
			patientRepo.save(patient);
		}
		return patient;
	}
	@Override
	public Doctor updateDoctor(Long id, String username, String password) {
		Doctor doctor=doctorRepo.getOne(id);
		doctor.setUserName(username);
		doctor.setPassword(password);
		return doctor;
	}
	@Override
	public Nurse updateNurse(Long id, String username, String password) {
		Nurse nurse=nurseRepo.getOne(id);
		nurse.setUserName(username);
		nurse.setPassword(password);
		return nurse;
	}
	@Override
	public Relative updateRelative(Long id, String username, String password) {
		Relative relative=relativeRepo.getOne(id);
		relative.setUserName(username);
		relative.setPassword(password);
		return relative;
	}
	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepo.findAll();
	}
	@SuppressWarnings("unused")
	
	@Override
	public List<Doctor> getPatientDoctors(Long id) {
		return doctorPatientRepo.getPatientDoctors(id);
	}
	@Override
	public Relative addRelative(String name, String surname, Long id) {
		Relative relative=new Relative(name,surname);
		Patient patient=patientRepo.getOne(id);
		patient.setRelative(relative);
		relative.setPatient(patient);
		relativeRepo.save(relative);
		return relative;
	}
	@Override
	public void deleteRelative(Long id) {
		relativeRepo.deleteById(id);
	}
	public void findme() {
		System.out.println("finded mee");
		
	}
	@Override
	public List<Patient> getDoctorPatient(Long id) {

		List<Patient> patients=doctorPatientRepo.getPatients(id);
		return patients;
		}
	
	@Override
	public DoctorPatient addDoctorPatient(Doctor doctor,Patient patient) {
	DoctorPatient dp=new DoctorPatient(doctor,patient);
	doctorPatientRepo.save(dp);	
		return dp;
	}
	@Override
	public List<Nurse> getDoctorNurses(Long id) {
		return doctorRepo.getDoctorNurses(id);
	}
	@Override
	public Nurse getNurseByUsername(String username) {
		return nurseRepo.getNurseByUsername(username);
	}
	@Override
	public Relative getRelativeByUsername(String username) {
		return relativeRepo.findRelative(username);
	}
	@Override
	public List<Patient> getNursePatients(Long id) {
		return nursePatientRepo.getNursePatients(id);
	}
	@Override
	public Relative getRelativeOfPatient(Long id) {
		return relativeRepo.getRelativeOfPatient(id);
	}
	@Override
	public List<Nurse> getPatientNurses(Long id) {
		return nursePatientRepo.getPatientNurses(id);
	}
	
}
