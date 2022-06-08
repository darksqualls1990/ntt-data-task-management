package com.accenture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.accenture.config.AppConfig;

@CrossOrigin(origins ="*")
@EnableScheduling
@EnableFeignClients
@Import( value= {AppConfig.class} ) 
@SpringBootApplication
public class AccentureApplication {
	
	/**
	 * Main method to start the spring boot application.
	 * 
	 * @param args application  arguments.
	 */
	public static void main(String[] args)  
	{    
		SpringApplication.run(AccentureApplication.class, args);    
	}   

}
