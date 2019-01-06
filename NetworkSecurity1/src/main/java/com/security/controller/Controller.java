package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.security.model.Doctor;
import com.security.model.Patient;
import com.security.service.SecurityServiceInterface;




//@Transactional(propagation = Propagation.NEVER)
public class Controller {
	public static Controller controller;
	
	@Autowired
	private SecurityServiceInterface securityService;
	
	public static Controller getController() {
		if(controller==null) {
			controller=new Controller();
		}
		
			return controller;
	}
	
	public SecurityServiceInterface getSecurityService() {
		return securityService;
	}
	
	public void setSecurityService(SecurityServiceInterface securityService) {
		this.securityService = securityService;
	}

	public boolean validateLogin(String username,String password,String user) {
		
		switch(user) {
			case "Doctor": 
				System.out.println("controller:"+username+password);
				securityService.doctorLogin(username, password);
				break;
			case "Patient":	
				 securityService.patientLogin(username,password);
			case "Nurse":
				return securityService.nurseLogin(username, password);
			case "Relative":
				return securityService.relativeLogin(username, password);
		}
		return false;
	}
	public void giveAuthorizationToDoctor(Long doctorId,Long patientId) {
		securityService.giveAuthorizationToDoctor(doctorId, patientId);
	}
	public void giveAuthorizationToNurse(Long nurseId,Long patientId) {
		securityService.giveAuthorizationToNurse(nurseId,patientId);
	}
	
	public List<Patient> getAllPatients(){
		return securityService.getAllPatients();
	}
	public Patient getPatientByUsername(String username) {
		return securityService.getPatientByUsername(username);
	}
	public Doctor getDoctorByUsername(String username) {
		return securityService.getDoctorByUsername(username);
	}
	
	public Patient addPatient(String name,String surname,String birthday,String diagnostic) {
		return securityService.addPatient(name,surname,birthday,diagnostic);
	}

	public void updateDoctor(Long id, String username, String password) {
		securityService.updateDoctor(id,username,password);
	}

	public void updateNurse(Long id, String username, String password) {
		securityService.updateNurse(id,username,password);
	}

	public void updateRelative(Long id, String username, String password) {
		securityService.updateRelative(id,username,password);
	}

	public List<Doctor> getAllDoctors() {
		return securityService.getAllDoctors();
	}

	public List<Doctor> getPatientDoctors(Long id) {
		return securityService.getPatientDoctors(id);
	}

	public void addRelative(String name, String surname, Long id) {
		securityService.addRelative(name,surname,id);
		
	}

	public void deleteRelative(Long id) {
		securityService.deleteRelative(id);
		
	}
}
