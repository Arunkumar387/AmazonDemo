package com.example.AmazonDemo;

import com.example.AmazonDemo.mapper.ECommerceMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AmazonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonDemoApplication.class, args);
	}


	@Bean
	public ECommerceMapper eCommerceMapper() {
		return ECommerceMapper.INSTANCE;
	}
}
