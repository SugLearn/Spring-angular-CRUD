package com.example.springangularcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan("com.example.springangularcrud")
@EnableJpaRepositories(basePackages ={"com.example.springangularcrud.dao"} )
@EntityScan(basePackages = {"com.example.springangularcrud.model"})
public class SpringAngularCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularCrudApplication.class, args);
	}

}
