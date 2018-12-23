package com.security.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.security.encryptionAlgorithm.Encryption;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String diagnostic;
	private String birthdate;
	private String password;
	private Relative relative;
	private List<NursePatient> nurses;
	private List<DoctorPatient> doctors;
	protected Patient() {}
	public Patient(String firstName,String lastName,String birthdate) {
		this.nurses=new ArrayList<>();
		this.doctors=new ArrayList<>();
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthdate=birthdate;
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
   
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relativeId")
	public Relative getRelative() {
		return relative;
	}
	public void setRelative(Relative relative) {
		this.relative = relative;
	}
	@OneToMany(mappedBy="nurse",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<NursePatient> getNurses() {
		return nurses;
	}
	public void addDoctor(DoctorPatient record) {
		
		doctors.add(record);
	}		

}