package com.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.security.encryptionAlgorithm.Encryption;

@Entity
public class Nurse {
			@Id
		    @GeneratedValue(strategy=GenerationType.AUTO)
		    private Long id;
		    private String firstName;
		    private String lastName;
		    private String userName;
		    private String password;
		    private Doctor doctor;
		    protected Nurse() {}
		    public Nurse(String firstName,String lastName) {
		    	this.firstName=firstName;
		    	this.lastName=lastName;
		    	this.userName=firstName+lastName;
		    }
			public Long getId() {
				return id;
			}
			public String getFirstName() {
				return firstName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setPassword(String password) {
				String pass=Encryption.sha256Encrypt(password);
				this.password = pass;
			}
			public String getPassword() {
				return password;
			}
			@ManyToOne
			@JoinColumn(name = "doctorId")
			public Doctor getDoctor() {
				return doctor;
			}
			public void setDoctor(Doctor doctor) {
				this.doctor = doctor;
			}
			public String getUserName() {
				return userName;
			}	
			
	}

