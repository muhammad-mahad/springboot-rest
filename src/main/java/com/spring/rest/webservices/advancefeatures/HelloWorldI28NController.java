package com.spring.rest.webservices.advancefeatures;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.webservices.helloworld.HelloWorldController;

@RestController
public class HelloWorldI28NController extends HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldI28NController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(preUrl + "-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
}