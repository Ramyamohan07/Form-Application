package com.validation.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.form.entity.FormData;
import com.validation.form.repository.FormRepository;

@Service
public class FormApplicationImpl implements FormService {
	@Autowired
	private FormRepository formRepository;
	
	@Override
	public FormData saveFormData(FormData formData) {
		return formRepository.save(formData);
	}
	

}
