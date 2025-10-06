package com.validation.form.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validation.form.entity.FormData;

public interface FormRepository extends JpaRepository<FormData, Long>{
	
	  Optional<FormData> findByEmail(String email);

	    Optional<FormData> findByPhoneNumber(String phoneNumber);

}
