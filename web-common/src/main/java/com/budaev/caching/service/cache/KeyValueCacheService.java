package com.budaev.caching.service.cache;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface KeyValueCacheService<K,V> {

	V add(K key, V value);

	String get(String key);
}
