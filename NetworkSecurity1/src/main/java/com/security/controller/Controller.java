package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Doctor;
import com.security.model.Patient;
import com.security.service.SecurityServiceInterface;



@Transactional(propagation = Propagation.NEVER)
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
	
	public boolean validateLogin(String userName,String password,String user) {
		switch(user) {
			case "Doctor": 
				return securityService.doctorLogin(userName, password);
			case "Patient":
				System.out.println(userName+password);
				String a=userName;
				String b=password;
				System.out.println(a+b);
				try {
				boolean flag= securityService.patientLogin(a,b);
					break;}catch(Exception e){
						e.getMessage();
					}
				case "Nurse":
				return securityService.nurseLogin(userName, password);
			case "Relative":
				return securityService.relativeLogin(userName, password);
		}
		return false;
	}
	public void giveAuthorizationToDoctor(String doctorUserName,String patientUserName) {
		securityService.giveAuthorizationToDoctor(doctorUserName, patientUserName);
	}
	public void giveAuthorizationToNurse(String nurseUserName,String patientUserName) {
		securityService.giveAuthorizationToNurse(nurseUserName,patientUserName);
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
}
