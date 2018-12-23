package com.security.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.security.encryptionAlgorithm.Encryption;

@Entity
public class Relative {
		 @Id
		    @GeneratedValue(strategy=GenerationType.AUTO)
		    private Long id;
		    private String firstName;
		    private String lastName;
		    private String password;
		    private Patient patient;
			protected Relative() {}
		    public Relative(String firstName,String lastName) {
		    	this.firstName=firstName;
		    	this.lastName=lastName;
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
			 @OneToOne(mappedBy="patient",fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
			public Patient getPatient() {
				return patient;
			}
			public void setPatient(Patient patient) {
				this.patient = patient;
			}
			
	}

