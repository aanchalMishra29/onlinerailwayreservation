package com.example.user;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.user.model.BookingOrder;
import com.example.user.model.UserModel;
import com.example.user.security.AuthenticationRequest;
import com.example.user.security.AuthenticationResponse;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
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
        		.ignoredParameterTypes(UserModel.class,BookingOrder.class,AuthenticationRequest.class,AuthenticationResponse.class)
        		.groupName("online railway reservation system")
        		.apiInfo(getInfo())
                .select()
                .paths(regex("/user.*"))
                .build();
    }
	
	    private ApiInfo getInfo() {
			return new ApiInfoBuilder().title("User Service")
					.description("Sample Documentation Generateed Using SWAGGER2 for our User Rest API")
					.build();
		}
	    }


	

