package com.security;

import java.awt.EventQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.security.dao.PatientRepository;
import com.security.model.Patient;
import com.security.view.AdminView;
import com.security.view.SpringContext;





@SpringBootApplication
public class NetworkSecurity1Application {
	private static final Logger logger = LoggerFactory.getLogger(NetworkSecurity1Application.class);
	public static void main(String[] args) {
		//SpringApplication.run(NetworkSecurity1Application.class, args);
	    SpringApplicationBuilder builder = new SpringApplicationBuilder(NetworkSecurity1Application.class);
	    builder.headless(false).run(args);
	}
	@Bean
	public CommandLineRunner setup(PatientRepository patientRepo) {
		return (args) -> {
			logger.info("Preloading " + patientRepo.save(new Patient("Bilbo", "Burglar","12.12.2010")));
			logger.info("The sample event data has been generated");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
			 ApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class); 
				AdminView adminView=(AdminView) context.getBean("adminView");
				adminView.run();
					}catch(Exception e) {
						e.printStackTrace();
					}
		}
			});
		};
	}

}

