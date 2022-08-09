package com.example.bookingorder;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bookingorder.model.BookingOrder;
import com.example.bookingorder.model.MailRequest;
import com.example.bookingorder.model.MailResponse;
import com.example.bookingorder.model.Train;
import com.example.bookingorder.model.UserModel;

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
        		.ignoredParameterTypes(BookingOrder.class,UserModel.class,Train.class,MailRequest.class,MailResponse.class)
        		.groupName("online railway reservation system")
        		.apiInfo(getInfo())
                .select()
                .paths(regex("/orders.*"))
                .build();
    }
	
	    private ApiInfo getInfo() {
			return new ApiInfoBuilder().title("Reservation Service")
					.description("Sample Documentation Generateed Using SWAGGER2 for our Reservation Rest API")
					.build();
		}
	}

