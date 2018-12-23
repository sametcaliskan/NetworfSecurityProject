package com.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class NursePatient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Nurse nurse;
	private Patient patient;
	protected NursePatient() {}
	public NursePatient(Nurse nurse,Patient patient) {
		this.nurse=nurse;
		this.patient=patient;
	}
	@ManyToOne
	@JoinColumn(name="nurseId")
	public Nurse getNurse() {
		return nurse;
	}
	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
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
