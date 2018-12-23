package com.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class DoctorPatient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Doctor doctor;
	private Patient patient;
	protected DoctorPatient() {};
	public DoctorPatient(Doctor doctor,Patient patient) {
		this.doctor=doctor;
		this.patient=patient;
	}
	@ManyToOne
	@JoinColumn(name="doctorId")
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@ManyToOne
	@JoinColumn(name="patientId")
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
