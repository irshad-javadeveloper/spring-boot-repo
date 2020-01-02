package com.restful.api.test.HelloWorldRestApp;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver.*;
import lombok.extern.java.Log;

/**
 * The Class DeployableWarApplication.
 * 
 * @author irshad
 * 
 */
@Log
@SpringBootApplication
@ComponentScan(basePackages = "com.restful")
public class DeployableWarApplication extends SpringBootServletInitializer {
	static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(DeployableWarApplication.class.getName());

	/**
	 * The method main .
	 * <p>
	 * Start spring boot applicat
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(DeployableWarApplication.class, args);
		//log.error("intered in main-method functions");
		//log.warning("main method warnning");
		log.info("main method exectuted successfully...");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DeployableWarApplication.class);
	}
	
	@Bean
	public SessionLocaleResolver localResolver() {
		SessionLocaleResolver localResolver=new SessionLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
		
	}
	
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
		
		
	}

}
