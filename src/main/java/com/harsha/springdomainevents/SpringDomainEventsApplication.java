package com.harsha.springdomainevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.harsha.springdomainevents.persistence.models")
public class SpringDomainEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDomainEventsApplication.class, args);
	}

}