package com.sapo.edu.demo;

import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.entity.WareHouse;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/auth").allowedOrigins("*");
//			}
//		};
//	}
}
