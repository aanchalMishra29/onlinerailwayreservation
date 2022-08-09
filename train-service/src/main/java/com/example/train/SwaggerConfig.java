package com.example.train;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;

import com.example.train.model.Train;

import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
	public class SwaggerConfig {

	@Bean
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.ignoredParameterTypes(Train.class)
        		.groupName("online railway reservation system")
        		.apiInfo(getInfo())
                .select()
                .paths(regex("/trains.*"))
                .build();
    }
	
	    private ApiInfo getInfo() {
			return new ApiInfoBuilder().title("Train Service")
					.description("Sample Documentation Generateed Using SWAGGER2 for our Train Rest API")
					.build();
		}
	    }

