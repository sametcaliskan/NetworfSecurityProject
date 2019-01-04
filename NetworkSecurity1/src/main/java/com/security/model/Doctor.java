package com.security.model;


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

	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private List<Nurse> nurses;
	private List<DoctorPatient> patients;

	protected Doctor() {}
	public Doctor(String firstName,String lastName,String password) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.userName=firstName+lastName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long  id) {
		this.id=id;
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
	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}
	public void setPatients(List<DoctorPatient> patients) {
		this.patients = patients;
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
	@OneToMany(mappedBy="doctor" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Nurse> getNurses() {
		return nurses;
	}
	@OneToMany(mappedBy="doctor",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
