package com.budaev.caching.memcached.service.cache.memcached;

import com.budaev.caching.service.cache.KeyValueCacheService;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@Service
@ConditionalOnProperty(prefix = "caching.provider", name = "type", havingValue = "memcached")
public class StringMemcachedService implements KeyValueCacheService<String, String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(StringMemcachedService.class);

	private static final String NAMESPACE = "key-value";

	@Override
	@ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
	public String add(@ParameterValueKeyProvider String key, String value) {
		try {
			TimeUnit.SECONDS.sleep(5L);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return value;
	}

	@Override
	@ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
	public String get(@ParameterValueKeyProvider String key) {
		try {
			TimeUnit.SECONDS.sleep(5L);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "";
	}
}
