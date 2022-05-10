package com.budaev.caching.redis.service.cache.redis;

import com.budaev.caching.service.cache.KeyValueCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "caching.provider", name = "type", havingValue = "redis")
public class StringRedisCacheService implements KeyValueCacheService<String, String> {

	private final RedisTemplate<String, String> redisTemplate;

	@Autowired
	public StringRedisCacheService(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String add(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
		return value;
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
}
