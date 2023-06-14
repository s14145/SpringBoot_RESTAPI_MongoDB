package com.mongodb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Person REST APIs", version = "1.0.0", description = "Spring Boot Person REST APIs using MongoDB", termsOfService = "Terms&Condition",
		contact = @Contact(name = "Ram", email = "dummy@gmail.com"), license = @License(name = "license", url = "PersonRESTAPI")))
public class SpringBootRestapiMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestapiMongoDbApplication.class, args);
	}

}
