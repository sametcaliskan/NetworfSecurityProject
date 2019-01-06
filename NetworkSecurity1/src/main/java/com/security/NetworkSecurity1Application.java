package com.security;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.security.dao.DoctorPatientRepository;
import com.security.dao.DoctorRepository;
import com.security.dao.NurseRepository;
import com.security.dao.PatientRepository;
import com.security.model.Doctor;
import com.security.model.DoctorPatient;
import com.security.model.Nurse;
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
	public CommandLineRunner setup(PatientRepository patientRepo,DoctorRepository doctorRepo,NurseRepository nurseRepo,DoctorPatientRepository doctorPatientRepo) {
		return (args) -> {
			Patient patient1=new Patient("samet", "calis","12.12.2010","kalp rahatsızlığı");
			Patient patient2=new Patient("fatih", "ak","12.12.1999","böbrek taşı rahatsızlığı");
			Patient patient3=new Patient("seyma", "kara","12.12.1985","sinüzit");
			Patient patient4=new Patient("didem", "bıyık","12.12.1991","grip");
			Patient patient5=new Patient("bengi", "sakal","12.12.1995","kol kırık");
			Patient patient6=new Patient("faruk", "kaya","12.12.1947","kalça kırık");
			Patient patient7=new Patient("ibo", "tatlı","12.12.1931","hamile");
			patientRepo.save(patient1);
			patientRepo.save(patient2);
			patientRepo.save(patient3);
			patientRepo.save(patient4);
			patientRepo.save(patient5);
			patientRepo.save(patient6);
			patientRepo.save(patient7);
			Doctor doctor1=new Doctor("ali","bas","1111");
			Doctor doctor2=new Doctor("veli","geri","2222");
			doctorRepo.save(doctor1);
			doctorRepo.save(doctor2);
			DoctorPatient dp1=new DoctorPatient(doctor1,patient1);
			DoctorPatient dp2=new DoctorPatient(doctor1,patient2);
			DoctorPatient dp3=new DoctorPatient(doctor1,patient3);
			DoctorPatient dp4=new DoctorPatient(doctor2,patient4);
			DoctorPatient dp5=new DoctorPatient(doctor2,patient5);
			DoctorPatient dp6=new DoctorPatient(doctor2,patient6);
			DoctorPatient dp7=new DoctorPatient(doctor2,patient7);
			logger.info("preloading dp1:" + doctorPatientRepo.save(dp1));
			logger.info("preloading dp2:" + doctorPatientRepo.save(dp2));
			logger.info("preloading dp3:" + doctorPatientRepo.save(dp3));
			logger.info("preloading dp4:" + doctorPatientRepo.save(dp4));
			logger.info("preloading dp5:" + doctorPatientRepo.save(dp5));
			logger.info("preloading dp6:" + doctorPatientRepo.save(dp6));
			logger.info("preloading dp7:" + doctorPatientRepo.save(dp7));
			Nurse nurse1=new Nurse("meryem","uzun");
			Nurse nurse2=new Nurse("ayse","kınık");
			Nurse nurse3=new Nurse("feride","kısa");
			Nurse nurse4=new Nurse("yaren","gök");
			nurse1.setDoctor(doctor1);
			nurse2.setDoctor(doctor1);
			nurse3.setDoctor(doctor2);
			nurse4.setDoctor(doctor2);
			nurseRepo.save(nurse1);
			nurseRepo.save(nurse2);
			nurseRepo.save(nurse3);
			nurseRepo.save(nurse4);
			
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

