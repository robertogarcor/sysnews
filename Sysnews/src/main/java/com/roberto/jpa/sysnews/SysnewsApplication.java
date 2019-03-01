package com.roberto.jpa.sysnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.roberto.jpa.sysnews")
public class SysnewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysnewsApplication.class, args);
	}

}
