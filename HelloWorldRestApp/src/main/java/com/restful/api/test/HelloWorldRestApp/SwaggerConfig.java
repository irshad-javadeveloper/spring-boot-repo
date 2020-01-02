package com.restful.api.test.HelloWorldRestApp;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Enable swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2);
	}
	// Bean - Docket
	//swagger2
	//All the paths
	//All the apis
	
}
