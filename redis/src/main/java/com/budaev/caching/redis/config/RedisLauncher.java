package com.budaev.caching.redis.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.budaev.caching")
public class RedisLauncher {

	public static void main(String[] args) {
		SpringApplication.run(RedisLauncher.class, args);
	}
}
