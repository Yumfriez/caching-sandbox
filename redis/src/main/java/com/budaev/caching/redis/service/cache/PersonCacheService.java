package com.budaev.caching.redis.service.cache;

import com.budaev.caching.redis.entity.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PersonCacheService {

	private static final String PERSON_HASH = "person";

	private final HashOperations<String, Long, Person> hashOperations;

	@Autowired
	public PersonCacheService(RedisTemplate<String, Serializable> redisTemplate) {
		this.hashOperations = redisTemplate.opsForHash();
	}

	public void save(Person person) {
		hashOperations.put(PERSON_HASH, person.getId(), person);
	}

	public Person get(Long id) {
		return hashOperations.get(PERSON_HASH, id);
	}

}
