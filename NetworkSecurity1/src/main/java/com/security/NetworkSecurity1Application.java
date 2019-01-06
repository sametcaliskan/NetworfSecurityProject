package com.security;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.security.dao.DoctorRepository;
import com.security.dao.PatientRepository;
import com.security.model.Doctor;
import com.security.model.Patient;
import com.security.view.LoginView;
import com.security.view.SpringContext;





@SpringBootApplication
public class NetworkSecurity1Application {
	private static final Logger logger = LoggerFactory.getLogger(NetworkSecurity1Application.class);
	public static void main(String[] args) {
		//SpringApplication.run(NetworkSecurity1Application.class, args);
	    SpringApplicationBuilder builder = new SpringApplicationBuilder(NetworkSecurity1Application.class);
	    builder.headless(false).run(args);
	}
	@SuppressWarnings("resource")
	@Bean
	public CommandLineRunner setup(PatientRepository patientRepo,DoctorRepository doctorRepo) {
		return (args) -> {
			logger.info("Preloading " + patientRepo.save(new Patient("samet", "calis","12.12.2010")));
			doctorRepo.save(new Doctor("ali","veli","sa"));
			logger.info("The sample event data has been generated");
			//EventQueue.invokeLater(new Runnable() {
			//	public void run() {
					try {
			 ApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class); 
				LoginView loginView=(LoginView) context.getBean("loginView");
				loginView.setVisible(true);
				
				//adminView.run();
					}catch(Exception e) {
						e.printStackTrace();
					}
		//}
			//});
		};
	}
}

