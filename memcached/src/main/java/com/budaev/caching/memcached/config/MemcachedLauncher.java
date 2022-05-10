package com.budaev.caching.memcached.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.budaev.caching")
public class MemcachedLauncher {

	public static void main(String[] args) {
		SpringApplication.run(MemcachedLauncher.class, args);
	}
}
