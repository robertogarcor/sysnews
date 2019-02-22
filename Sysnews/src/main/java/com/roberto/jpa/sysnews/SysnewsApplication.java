package com.roberto.jpa.sysnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SysnewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysnewsApplication.class, args);
	}

}
