package com.security.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.security.encryptionAlgorithm.Encryption;

@Entity
public class Nurse {

	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Doctor doctor;
	private List<NursePatient> patients;
	protected Nurse() {}
	public Nurse(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=firstName+lastName;
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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPatients(List<NursePatient> patients) {
		this.patients = patients;
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
	public void addPatient(NursePatient patient) {
		patients.add(patient);
	}
	@OneToMany(mappedBy="nurse",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<NursePatient> getPatients() {
		return patients;
	}
}

