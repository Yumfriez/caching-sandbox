package com.budaev.caching.redis.service.cache.redis;

import com.budaev.caching.entity.model.Person;
import com.budaev.caching.service.cache.PersonCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class RedisPersonCacheService implements PersonCacheService {

	private static final String PERSON_HASH = "person";

	private final HashOperations<String, Long, Person> hashOperations;

	@Autowired
	public RedisPersonCacheService(RedisTemplate<String, Serializable> redisTemplate) {
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Person person) {
		hashOperations.put(PERSON_HASH, person.getId(), person);
	}

	@Override
	public Optional<Person> get(Long id) {
		return Optional.ofNullable(hashOperations.get(PERSON_HASH, id));
	}

}
