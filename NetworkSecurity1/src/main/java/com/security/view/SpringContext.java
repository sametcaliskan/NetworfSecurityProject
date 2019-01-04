package com.security.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
	@PropertySource("classpath:application.properties")
	public class SpringContext {
	   @Value("${title}")
	    String title;

	    @Bean(name = "loginView")
	    public LoginView createAdminView() {
	    	 //System.setProperty("java.awt.headless", "false");
	        return new LoginView(title);
	    }

	    @Bean
	    public static PropertySourcesPlaceholderConfigurer setUp() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }
	}
