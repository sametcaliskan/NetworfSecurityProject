package com.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Doctor;
import com.security.model.Nurse;
@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor,Long>,DoctorRepositoryInterface {

	

}
