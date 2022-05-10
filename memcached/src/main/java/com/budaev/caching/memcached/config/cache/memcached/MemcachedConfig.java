package com.budaev.caching.memcached.config.cache.memcached;

import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.AbstractSSMConfiguration;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl;
import com.google.code.ssm.providers.xmemcached.XMemcachedConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@Configuration
@EnableCaching
@EnableAspectJAutoProxy
public class MemcachedConfig extends AbstractSSMConfiguration {

	@Bean
	@Override
	public CacheFactory defaultMemcachedClient() {

		final XMemcachedConfiguration conf = new XMemcachedConfiguration();
		conf.setUseBinaryProtocol(true);

		final CacheFactory cf = new CacheFactory();
		cf.setCacheClientFactory(new MemcacheClientFactoryImpl());
		cf.setAddressProvider(new DefaultAddressProvider("localhost:11211"));
		cf.setConfiguration(conf);
		return cf;
	}
}
