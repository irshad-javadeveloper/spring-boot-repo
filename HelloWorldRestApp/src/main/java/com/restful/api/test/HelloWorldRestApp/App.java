package com.restful.api.test.HelloWorldRestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages="com.restful")
public class App extends SpringBootServletInitializer
{
    /*public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(DeployableWarApplication.classs);
		
          } */
    
}
