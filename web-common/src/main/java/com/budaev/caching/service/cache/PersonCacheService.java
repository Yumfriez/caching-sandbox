package com.budaev.caching.service.cache;

import com.budaev.caching.entity.model.Person;

import java.util.Optional;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface PersonCacheService {

	void save(Person person);

	Optional<Person> get(Long id);
}
