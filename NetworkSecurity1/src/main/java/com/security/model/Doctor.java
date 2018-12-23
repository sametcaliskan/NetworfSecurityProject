package com.security.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.security.encryptionAlgorithm.Encryption;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private List<Nurse> nurses;
	private List<DoctorPatient> patients;

	protected Doctor() {}
	public Doctor(String firstName,String lastName) {
		this.nurses=new ArrayList<>();
		this.patients=new ArrayList<>();
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
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	@OneToMany(mappedBy="nurse" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Nurse> getNurses() {
		return nurses;
	}
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<DoctorPatient> getPatients() {
		return patients;
	}
	public void setPassword(String password) {
		String pass=Encryption.sha256Encrypt(password);
		this.password = pass;
	}
	public void addPatient(DoctorPatient patient) {
		patients.add(patient);
	}

}
