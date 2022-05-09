package com.budaev.caching.redis.controller;

import com.budaev.caching.redis.entity.model.Person;
import com.budaev.caching.redis.service.person.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping(value = "/add")
	public void add(@RequestParam(value = "id") Long id, @RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password) {
		personService.create(new Person(id, login, password));
	}

	@GetMapping(value = "/{id}")
	public Person get(@PathVariable(value = "id") Long id) {
		return personService.get(id);
	}
}
