package com.resolve.geofenceService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class GeofenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeofenceServiceApplication.class, args);
	}

}
