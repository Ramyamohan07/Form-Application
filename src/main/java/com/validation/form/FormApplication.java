package com.validation.form;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormApplication {
	private static final Logger logger = LogManager.getLogger(FormApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
		logger.info("Form Application is Started...");
	}

}
