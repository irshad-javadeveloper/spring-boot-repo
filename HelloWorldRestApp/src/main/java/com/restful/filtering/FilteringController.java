package com.restful.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	// static filter applied
	/*
	 * @GetMapping("/filtering") public SomeBean retriveSomeBean() {
	 * 
	 * return new SomeBean("value1","Value2","Value3"); }
	 * 
	 * @GetMapping("/filtering-list") public List<SomeBean> retriveListOfSomeBean()
	 * {
	 * 
	 * return Arrays.asList(new SomeBean("value1","Value2","Value3"), new
	 * SomeBean("value12","Value22","Value33")); }
	 *
	 *
	 */
	// dynamic fileter applied particular request
	// field1,field2

	@GetMapping("/filtering")
	public MappingJacksonValue retriveSomeBean() {

		SomeBean someBean = new SomeBean("value1", "Value2", "Value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retriveListOfSomeBean() {

		List<SomeBean>list=Arrays.asList(new SomeBean("value1","Value2","Value3"), new SomeBean("value12","Value22","Value33"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}

}
