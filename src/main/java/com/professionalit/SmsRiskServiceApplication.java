package com.professionalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SmsRiskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsRiskServiceApplication.class, args);
	}

}
