package com.security.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.security.encryptionAlgorithm.Encryption;

@Entity
public class Patient {

	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String diagnostic;
	private String birthdate;
	private String password;
	private Relative relative;
	private List<NursePatient> nurses;
	private List<DoctorPatient> doctors;
	protected Patient() {}
	public Patient(String firstName,String lastName,String birthdate) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=firstName+lastName;
		System.out.println(userName);
		this.birthdate=birthdate;
	}public Patient(String name,String surname,String birthdate,String diagnostic) {
		this.firstName=name;
		this.lastName=surname;
		this.birthdate=birthdate;
		this.diagnostic=diagnostic;
		this.userName=firstName+userName;
		
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
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public void setId(Long id) {
		this.id=id;
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
	public String getDiagnostic() {
		return diagnostic;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setPassword(String password) {
		String pass=Encryption.sha256Encrypt(password);
		this.password = pass;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
   

    @OneToOne(mappedBy="patient", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	public Relative getRelative() {
		return relative;
	}
	public void setRelative(Relative relative) {
		this.relative = relative;
	}
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<NursePatient> getNurses() {
		return nurses;
	}
	public void addDoctor(DoctorPatient record) {
		
		doctors.add(record);
	}		
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<DoctorPatient> getDoctors() {
		return doctors;
	}
	public void addNurse(NursePatient nurse) {
		nurses.add(nurse);
	}
	public void setNurses(List<NursePatient> nurses) {
		this.nurses = nurses;
	}
	public void setDoctors(List<DoctorPatient> doctors) {
		this.doctors = doctors;
	}

}