package com.budaev.caching.redis.controller;

import com.budaev.caching.redis.service.cache.CacheService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dummy")
public class DummyController {

	private final CacheService cacheService;

	public DummyController(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@GetMapping(value = "/add")
	public Pair<String, String> add(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
		return cacheService.add(key, value);
	}

	@GetMapping(value = "/{key}")
	public String get(@PathVariable(value = "key") String key) {
		return cacheService.get(key);
	}
}
