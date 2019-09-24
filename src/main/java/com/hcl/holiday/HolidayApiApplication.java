package com.hcl.holiday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HolidayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidayApiApplication.class, args);
	}

}
