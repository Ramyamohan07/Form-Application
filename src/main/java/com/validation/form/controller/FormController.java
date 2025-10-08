package com.validation.form.controller;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.validation.form.entity.FormData;
import com.validation.form.service.FormService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/form")
//@CrossOrigin(origins = "*")
public class FormController {
//	  private static final Logger logger = LoggerFactory.getLogger(FormController.class);
	@Autowired
	private FormService formService;

	@PostMapping("/submit")
	public ResponseEntity<?> submitForm(@RequestBody FormData formData) {
	    try {
	        FormData saveData = formService.saveFormData(formData);
	        return ResponseEntity.ok(saveData);
	    } catch (RuntimeException e) {
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body(e.getMessage());
	    } catch (Exception e) {
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Something went wrong. Please try again.");
	    }
	}
	
	@GetMapping("/hello")
	public String getMethodName() {
		return "Application Working Fine😁";
	}
	
}
