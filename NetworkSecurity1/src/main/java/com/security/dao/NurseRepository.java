package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Nurse;
@Repository("nurseRepository")
public interface NurseRepository extends JpaRepository<Nurse,Long>, NurseRepositoryInterface{

	

}
