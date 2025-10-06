package com.validation.form.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.form.controller.FormController;
import com.validation.form.entity.FormData;
import com.validation.form.repository.FormRepository;

@Service
public class FormApplicationImpl implements FormService {
	private static final Logger logger = LoggerFactory.getLogger(FormController.class);
	@Autowired
	private FormRepository formRepository;

	@Override
	public FormData saveFormData(FormData formData) {
		if (formRepository.findByEmail(formData.getEmail()).isPresent()) {
			logger.info("Email ID is already registered");
			throw new RuntimeException("Email ID is already registered");
		}

		if (formRepository.findByPhoneNumber(formData.getPhoneNumber()).isPresent()) {
			logger.info("Phone number is already registered");
			throw new RuntimeException("Phone number is already registered");
		}

		return formRepository.save(formData);
	}

}
