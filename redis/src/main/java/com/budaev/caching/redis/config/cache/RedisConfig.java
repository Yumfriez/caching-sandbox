package com.budaev.caching.redis.config.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.io.Serializable;

@Configuration
public class RedisConfig {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
	}

	@Bean
	public RedisTemplate<String, Serializable> redisTemplate() {
		final RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory());
		final Jackson2JsonRedisSerializer serializer = jackson2JsonRedisSerializer();
		template.setValueSerializer(serializer);
		template.setHashKeySerializer(serializer);
		template.setHashValueSerializer(serializer);
		template.setValueSerializer(serializer);
		template.afterPropertiesSet();
		return template;
	}

	@Bean
	public Jackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
		final Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(redisObjectMapper());
		return jackson2JsonRedisSerializer;
	}

	@Bean
	public ObjectMapper redisObjectMapper() {

		return JsonMapper.builder()
				.visibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
				.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
						ObjectMapper.DefaultTyping.NON_FINAL,
						JsonTypeInfo.As.WRAPPER_ARRAY
				)
				.annotationIntrospector((new JacksonAnnotationIntrospector()))
				.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.addModule(new JavaTimeModule())
				.build();

	}
}
