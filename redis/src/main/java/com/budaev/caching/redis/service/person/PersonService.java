package com.budaev.caching.redis.service.person;

import com.budaev.caching.redis.entity.exception.UserNotFoundException;
import com.budaev.caching.redis.entity.model.Person;
import com.budaev.caching.redis.service.cache.PersonCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

	private final PersonCacheService personCacheService;

	@Autowired
	public PersonService(PersonCacheService personCacheService) {
		this.personCacheService = personCacheService;
	}

	public void create(Person person) {
		validate(person);
		personCacheService.save(person);
	}

	public Person get(Long id) {
		return Optional.ofNullable(personCacheService.get(id)).orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
	}

	private void validate(Person person) {
		//validation logic
	}
}
