package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.security.service.ServiceImpl;


public class Controller {
	@Autowired
	private ServiceImpl securityService;
	
	
	
	public boolean login(String userName,String password,String user) {
		switch(user) {
			case "Doctor": 
				return securityService.doctorLogin(userName, password);
			case "Patient":
				return securityService.patientLogin(userName, password);
			case "Nurse":
				return securityService.nurseLogin(userName, password);
			case "Relative":
				return securityService.relativeLogin(userName, password);
		}
		return false;
	}
}
