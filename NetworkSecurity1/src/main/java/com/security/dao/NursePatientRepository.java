package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.NursePatient;

@Repository("nursePatientRepository")
public interface NursePatientRepository extends JpaRepository<NursePatient,Long>, NursePatientRepositoryInterface {

}
