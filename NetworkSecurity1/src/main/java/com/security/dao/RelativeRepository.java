package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Relative;
@Repository("relativeRepository")
public interface RelativeRepository extends JpaRepository<Relative,Long>,RelativeRepositoryInterface{



}
