package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Doctor;
@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor,Long>,DoctorRepositoryInterface {

}
