package com.validation.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validation.form.entity.FormData;

public interface FormRepository extends JpaRepository<FormData, Long>{

}
