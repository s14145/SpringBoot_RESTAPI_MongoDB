package com.mongodb.config;

/**
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }


    private ApiInfo getInfo(){
        return new ApiInfo("Person REST APIs", "Spring Boot Person REST APIs using MongoDB", "1.0.0","Terms of Service",
                new Contact("Ram","https://personrestapi.com", "dummy@gmail.com"), "License of Person APIs", "API License URL", Collections.emptyList());
    }
}*/