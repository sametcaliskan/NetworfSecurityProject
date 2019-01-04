package com.security.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.security.encryptionAlgorithm.Encryption;

@Entity
public class Relative {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String password;
	private String username;
	private Patient patient;
	protected Relative() {}
	public Relative(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.username=firstName+lastName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
    @OneToOne
    @JoinColumn(name ="patientId")
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getUsername() {
		return username;
	}

}

