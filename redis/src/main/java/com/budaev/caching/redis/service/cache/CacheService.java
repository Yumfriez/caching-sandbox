package com.budaev.caching.redis.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class CacheService {

	private final RedisTemplate<String, String> redisTemplate;

	@Autowired
	public CacheService(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public Pair<String, String> add(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
		return Pair.of(key, value);
	}

	public String get(String key) {
		return ofNullable(redisTemplate.opsForValue().get(key)).orElse("");
	}
}
