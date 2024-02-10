package com.spring.rest.webservices.advancefeatures;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.webservices.user.User;
import com.spring.rest.webservices.user.UserController;
import com.spring.rest.webservices.user.UserDaoService;
import com.spring.rest.webservices.user.UserNotFoundException;

@RestController
public class UserHateoasController extends UserController {
	private UserDaoService service;

	public UserHateoasController(UserDaoService service) {
		super(service);
		this.service = service;
	}

	@GetMapping("/users-hateoas/{id}")
	public EntityModel<User> retrieveUserHateoas(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null)
			throw new UserNotFoundException("id:" + id);

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}
}
