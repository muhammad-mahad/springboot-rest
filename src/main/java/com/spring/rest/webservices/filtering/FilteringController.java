package com.spring.rest.webservices.filtering;

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
	private static final String DYNAMIC_URL = "filtering-dynamic";

	@GetMapping("filtering-static") // field2
	public SomeBeanStaticFilter staticFiltering() {
		return new SomeBeanStaticFilter("value1", "value2", "value3", "value4", "value5", "value6", "value7");
	}

	@GetMapping(DYNAMIC_URL) // field2
	public MappingJacksonValue filtering() {

		SomeBeanDynamicFilter someBean = new SomeBeanDynamicFilter("value1", "value2", "value3");

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

	@GetMapping(DYNAMIC_URL + "-list") // field2, field3
	public MappingJacksonValue filteringList() {
		List<SomeBeanDynamicFilter> list = Arrays.asList(new SomeBeanDynamicFilter("value1", "value2", "value3"),
				new SomeBeanDynamicFilter("value4", "value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}
}
