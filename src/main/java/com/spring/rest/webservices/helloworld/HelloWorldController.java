package com.spring.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class HelloWorldController {
	protected static final String preUrl = "hello-world";

	@GetMapping(preUrl)
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(preUrl + "-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(preUrl + "/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}