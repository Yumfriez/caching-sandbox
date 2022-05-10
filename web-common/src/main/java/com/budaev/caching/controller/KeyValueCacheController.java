package com.budaev.caching.controller;

import com.budaev.caching.service.cache.KeyValueCacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kv")
public class KeyValueCacheController {

	private final KeyValueCacheService<String, String> cacheService;

	public KeyValueCacheController(KeyValueCacheService<String, String> cacheService) {
		this.cacheService = cacheService;
	}

	@GetMapping(value = "/add")
	public String add(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
		return cacheService.add(key, value);
	}

	@GetMapping(value = "/{key}")
	public String get(@PathVariable(value = "key") String key) {
		return cacheService.get(key);
	}
}
