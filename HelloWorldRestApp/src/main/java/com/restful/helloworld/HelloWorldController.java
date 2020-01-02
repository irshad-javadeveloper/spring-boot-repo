package com.restful.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello")
	public String helloWorld(){
		return "welcome to restful services";
	}
	
	@GetMapping(path="/hello-bean")
	public HelloworldBean helloWorldBean(){
		
		return new HelloworldBean("welcome to world of restfull services");
	}
	
	//@PathVariable
	//hello-bean/path-variable/irshad
	@GetMapping(path="/hello-bean/path-variable/{name}")
	public HelloworldBean helloWorldBeanPathVariable(@PathVariable String name){
		
		return new HelloworldBean(String.format("welcome to world of restfull services, %s",name));
	}
	
	@GetMapping(path="/hello-world-internatiolization")
	public String helloWorldInternationalization(@RequestHeader(name="Accept-Langague",required=false) Locale locale) {
		
		return messageSource.getMessage("good.morning.message",null, locale);
	}

}
