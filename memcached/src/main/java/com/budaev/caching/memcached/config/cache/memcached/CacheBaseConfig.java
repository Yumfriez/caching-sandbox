package com.budaev.caching.memcached.config.cache.memcached;

import com.google.code.ssm.aop.CacheBase;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@Configuration
public class CacheBaseConfig {

	private final CacheBase cacheBase;

	public CacheBaseConfig(CacheBase cacheBase) {
		this.cacheBase = cacheBase;
	}

	@PostConstruct
	void updateCacheBase() throws Exception {
		cacheBase.afterPropertiesSet();
	}

//	@Bean
//	public CacheManager cacheManager() throws Exception {
//		ExtendedSSMCacheManager cacheManager = new ExtendedSSMCacheManager();
//		Cache cache = cacheFactory.getObject();
//		cacheManager.setCaches(List.of(new SSMCache(cache, 0, false)));
//		return cacheManager;
//	}

}
