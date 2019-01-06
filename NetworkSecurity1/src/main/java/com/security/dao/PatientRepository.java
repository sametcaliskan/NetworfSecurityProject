package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Patient;
import com.security.model.Relative;

@Repository("patientRepository")
public interface PatientRepository extends JpaRepository<Patient,Long>,PatientRepositoryInterface{



}
